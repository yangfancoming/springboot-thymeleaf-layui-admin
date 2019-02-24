package com.chang.repository;

import com.chang.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ANdady on 2019/2/23.
 */
@Repository
public interface SysUserRepository extends JpaRepository<SystemUser, Long>, JpaSpecificationExecutor<SystemUser> {
}
