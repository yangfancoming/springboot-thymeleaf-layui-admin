package com.chang.service;

import com.chang.model.SystemMenu;
import com.chang.param.SysMenuDTO;
import com.chang.repository.SysMenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ANdady on 2019/2/23.
 */
@Service
@Transactional
public class SysMenuService {

    @Autowired
    private SysMenuRepository menuRepository;

    /**
     * 加载系统菜单(树状图)
     *
     * @return {List} 系统菜单
     * @throws Exception
     */
    public List<SystemMenu> findAllSysMenu() throws Exception {
        List<SystemMenu> menus = menuRepository.findAll(new Specification<SystemMenu>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<SystemMenu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.isFalse(root.get("isDelete")));
                list.add(criteriaBuilder.isTrue(root.get("isParent")));

                Predicate[] predicates = new Predicate[list.size()];
                return criteriaQuery
                        .where(list.toArray(predicates))
                        .orderBy(criteriaBuilder.asc(root.get("sortNo")))
                        .getRestriction();
            }
        });
        menus.forEach(menu -> menu.getSubmenus().sort(Comparator.comparingInt(SystemMenu::getSortNo))); //对子菜单进行排序

        return menus;
    }

    public SystemMenu findSysMenu(long menuId) throws Exception {
        SystemMenu menu = menuRepository.findById(menuId).orElse(null);
        Assert.notNull(menu, "无法获取系统菜单信息(无效的menuId)");

        return menu;
    }

    public void saveSysMenu(SysMenuDTO sysMenuDTO) throws Exception {

    }

    public void modifySysMenu(SysMenuDTO sysMenuDTO) throws Exception {

    }
}
