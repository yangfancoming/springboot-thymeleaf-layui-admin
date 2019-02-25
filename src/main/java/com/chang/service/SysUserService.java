package com.chang.service;

import com.chang.model.SystemUser;
import com.chang.param.SysUserDTO;
import com.chang.param.SysUserQuery;
import com.chang.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANdady on 2019/2/23.
 */
@Service
@Transactional
public class SysUserService {

    @Autowired
    private SysUserRepository userRepository;

    /**
     * 加载管理员信息
     *
     * @param pageNo 当前页码
     * @param limit 每页显示的数据量
     * @param query 查询条件
     * @return {Page}
     * @throws Exception
     */
    public Page<SystemUser> findAllSysUser(int pageNo, int limit, SysUserQuery query) throws Exception {
        Pageable pageable = PageRequest.of(pageNo - 1, limit, Sort.by(Sort.Direction.DESC, "createdDt"));
        Page<SystemUser> page = userRepository.findAll(new Specification<SystemUser>() {
            @org.springframework.lang.Nullable
            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<SystemUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

//                List<Predicate> predicates = new ArrayList<>();
//                if(null != minDate){
//                    predicates.add(criteriaBuilder.greaterThan(root.get("subscribeTime"), minDate));
//                }
//                if(null != maxDate){
//                    predicates.add(criteriaBuilder.lessThan(root.get("subscribeTime"), maxDate));
//                }
//                if(null != nickname){
//                    predicates.add(criteriaBuilder.like(root.get("nickname"), "%"+nickname+"%"));
//                }
//                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));


                List<javax.persistence.criteria.Predicate> list = new ArrayList<>();
                javax.persistence.criteria.Predicate[] predicates = new javax.persistence.criteria.Predicate[list.size()];
                return criteriaQuery.where(list.toArray(predicates)).getRestriction();
            }
        }, pageable);

        return page;
    }

    SystemUser findSysUser(long userId) throws Exception {
        SystemUser sysuser = userRepository.findById(userId).orElse(null);
        Assert.notNull(sysuser, "无法获取管理员信息(userid不存在)");

        return sysuser;
    }

    public void saveSysUser(SysUserDTO sysUserDTO) throws Exception {

    }

    public void modifySysUser(SysUserDTO sysUserDTO) throws Exception {

    }
}
