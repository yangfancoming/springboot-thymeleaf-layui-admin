package com.chang.service;

import com.chang.model.SystemMenu;
import com.chang.param.SysMenuDTO;
import com.chang.param.SysMenuQuery;
import com.chang.repository.SysMenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ANdady on 2019/2/23.
 */
@Service
@Transactional
public class SysMenuService {

    @Autowired
    private SysMenuRepository menuRepository;

    /**
     * 加载系统菜单(无需分页, 一次性全部显示)
     * <p>
     * tips: 先加载所有的父节点
     * <p>
     * update: 将匿名类换成了Lamda
     *
     * @param query 查询参数
     * @return {List} 系统菜单
     * @throws Exception
     */
    public List<SystemMenu> findAllSysMenu(SysMenuQuery query) throws Exception {
//        List<SystemMenu> menus = menuRepository.findAll(new Specification<SystemMenu>() {
//            @Nullable
//            @Override
//            public Predicate toPredicate(Root<SystemMenu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                List<Predicate> list = new ArrayList<>();
//                list.add(criteriaBuilder.isFalse(root.get("isDelete")));
//                list.add(criteriaBuilder.isTrue(root.get("isParent")));
//
//                Predicate[] predicates = new Predicate[list.size()];
//                return criteriaQuery
//                        .where(list.toArray(predicates))
//                        .orderBy(criteriaBuilder.asc(root.get("sortNo")))
//                        .getRestriction();
//            }
//        });

        List<SystemMenu> menus = menuRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.isFalse(root.get("isDelete")));
            list.add(criteriaBuilder.isTrue(root.get("isParent")));

            Predicate[] predicates = new Predicate[list.size()];
            return criteriaQuery
                    .where(list.toArray(predicates))
                    .orderBy(criteriaBuilder.asc(root.get("sortNo")))
                    .getRestriction();
        });

        menus.forEach(menu -> menu.getSubmenus().sort(Comparator.comparingInt(SystemMenu::getSortNo))); //对子菜单进行排序

        List<SystemMenu> result = new ArrayList<>();
        result.addAll(menus);

        for (SystemMenu menu : menus) {
            int index = result.indexOf(menu); //获取元素下标
            List<SystemMenu> submenus = menu.getSubmenus().stream().filter(submenu -> !submenu.isDelete()).collect(Collectors.toList()); //过滤已删除的子菜单

            result.addAll(index + 1, submenus);
        }

        return result;
    }

    public SystemMenu findSysMenu(long menuId) throws Exception {
        SystemMenu menu = menuRepository.findById(menuId).orElse(null);
        Assert.notNull(menu, "无法获取系统菜单信息(无效的menuId)");

        return menu;
    }

    /**
     * 保存一级菜单信息
     * <p>
     * 注: 若有参数中带有二级菜单信息, 则将其保存
     *
     * @param sysMenuDTO 菜单参数
     * @throws Exception
     */
    public void saveParentSysMenu(SysMenuDTO sysMenuDTO) throws Exception {
        SystemMenu parentmenu = sysMenuDTO.getSysMenuInstance();
        parentmenu.setUrl("#"); //父节点默认URL(后期可能会改进)
        parentmenu.setParent(true);

        menuRepository.save(parentmenu);
    }

    /**
     * 保存二级菜单
     *
     * @param sysMenuDTO 菜单参数
     * @throws Exception
     */
    public void saveSubSysMenu(Long parentId, SysMenuDTO sysMenuDTO) throws Exception {
        Assert.notNull(parentId, "一级菜单ID为空");

        SystemMenu parentmenu = menuRepository.findById(parentId).orElse(null);
        Assert.notNull(parentmenu, "无法获取一级菜单信息,");

        SystemMenu submenu = sysMenuDTO.getSysMenuInstance();
        submenu.setParent(false);
        menuRepository.save(submenu); //保存二级菜单

        parentmenu.getSubmenus().add(submenu);
        menuRepository.save(parentmenu); //保存一级菜单
    }

    /**
     * 修改系统菜单
     *
     * @param menuId     菜单ID
     * @param sysMenuDTO 菜单DTO
     * @throws Exception
     */
    public void modifySysMenu(Long menuId, SysMenuDTO sysMenuDTO) throws Exception {
        Assert.notNull(menuId, "菜单ID为空");

        SystemMenu sysmenu = menuRepository.findById(menuId).orElse(null);
        Assert.notNull(sysmenu, "无法获取菜单信息(菜单ID不存在)");

        sysMenuDTO.transfer(sysmenu);

        menuRepository.save(sysmenu);
    }

    /**
     * 删除一级菜单
     * <p>
     * 注: 需删除与其关联的为二级菜单
     *
     * @param menuId 菜单ID
     * @throws Exception
     */
    public void deleteSysMenus(Long menuId) throws Exception {
        Assert.notNull(menuId, "菜单ID为空");

        SystemMenu menu = menuRepository.findById(menuId).orElse(null);
        Assert.notNull(menu, "无法获取菜单信息(菜单ID不存在)");

        if (menu.isParent()) deleteAllSubMenu(menu);

        menu.setDelete(true);
        menuRepository.save(menu);
    }

    /**
     * 删除一级菜单所关联的二级菜单
     *
     * @param parentmenu 一级菜单
     * @throws Exception
     */
    public void deleteAllSubMenu(SystemMenu parentmenu) throws Exception {
        List<SystemMenu> submenus = parentmenu.getSubmenus();
        if (submenus.isEmpty()) return;

        submenus.stream().forEach(menu -> menu.setDelete(true));
        menuRepository.saveAll(submenus);
    }
}
