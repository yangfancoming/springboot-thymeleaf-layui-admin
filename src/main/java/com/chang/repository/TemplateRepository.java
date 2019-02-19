package com.chang.repository;

import com.chang.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by ANdady on 2019/2/12.
 */
@Repository
public interface TemplateRepository extends JpaRepository<Template, Long>, JpaSpecificationExecutor<Template> {
}
