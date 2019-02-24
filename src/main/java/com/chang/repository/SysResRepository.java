package com.chang.repository;

import com.chang.model.SystemResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ANdady on 2019/2/23.
 */
@Repository
public interface SysResRepository extends JpaRepository<SystemResource, Long>, JpaSpecificationExecutor<SystemResource> {
}
