package com.chang.repository;

import com.chang.model.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ANdady on 2019/2/23.
 */
@Repository
public interface SysRoleRepository extends JpaRepository<SystemRole, Long>, JpaSpecificationExecutor<SystemRole> {
}
