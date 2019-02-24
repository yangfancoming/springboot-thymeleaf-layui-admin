package com.chang.repository;

import com.chang.model.SystemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ANdady on 2019/2/23.
 */
@Repository
public interface SysMenuRepository extends JpaRepository<SystemMenu, Long>, JpaSpecificationExecutor<SystemMenu> {
}
