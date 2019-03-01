package com.chang.service;

import com.chang.model.SystemResource;
import com.chang.param.SysResDTO;
import com.chang.param.SysResQuery;
import com.chang.repository.SysResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ANdady on 2019/2/23.
 */
@Service
@Transactional
public class SysResService {

    @Autowired
    private SysResRepository resRepository;

    /**
     * 加载资源(权限)数据
     *
     * @param pageNo 当前页码
     * @param limit 每页的数据量
     * @param query 查询条件
     * @return {Page} 分页数据
     * @throws Exception
     */
    public Page<SystemResource> findAllSysRes(int pageNo, int limit, SysResQuery query) throws Exception {
        Pageable pageable = PageRequest.of(pageNo, limit);

        Page<SystemResource> page = resRepository.findAll(((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            javax.persistence.criteria.Predicate[] predicates = new javax.persistence.criteria.Predicate[list.size()];
            return criteriaQuery.where(list.toArray(predicates)).getRestriction();
        }), pageable);

        return null;
    }

    /**
     * 通过ID获取系统资源
     *
     * @param resourceId 资源ID
     * @return {SystemResource} 系统资源
     * @throws Exception
     */
    public SystemResource findSysRes(Long resourceId) throws Exception {
        Assert.notNull(resourceId, "资源ID为空");

        SystemResource resource = resRepository.findById(resourceId).orElse(null);
        Assert.notNull(resource, "");

        return resource;
    }

    /**
     * 保存资源信息
     *
     * @param sysResDTO 系统资源DTO
     * @throws Exception
     */
    public void saveSysRes(SysResDTO sysResDTO) throws Exception {
        SystemResource resource = sysResDTO.getSysResInstance();
        resRepository.save(resource);
    }

    /**
     * 编辑资源信息
     *
     * @param resId 资源ID
     * @param sysResDTO 系统资源DTO
     * @throws Exception
     */
    public void modifySysRes(Long resId, SysResDTO sysResDTO) throws Exception {
        Assert.notNull(resId, "资源ID为空");

        SystemResource resource = resRepository.findById(resId).orElse(null);
        Assert.notNull(resource, "无法获取系统资源(资源ID不存在)");

        sysResDTO.transfer(resource);
        resRepository.save(resource);
    }

    /**
     * 删除资源
     *
     * @param resId 资源ID
     * @throws Exception
     */
    public void deleteSysRes(Long resId) throws Exception {
        Assert.notNull(resId, "资源ID为空");
        resRepository.deleteById(resId);
    }
}
