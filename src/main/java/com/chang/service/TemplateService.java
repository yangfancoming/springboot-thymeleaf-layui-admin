package com.chang.service;

import com.chang.model.Template;
import com.chang.param.TemplateDTO;
import com.chang.param.TemplateQuery;
import com.chang.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANdady on 2019/2/12.
 */
@Service
@Transactional
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    /**
     * 查询分页数据
     * <p>
     * tips: override的过程可是用lamda表示式进行优化
     *
     * @param pageNo 当前页码
     * @param limit 每页的数据量
     * @param query 查询条件
     * @return {Page} 分页数据
     */
    public Page<Template> findAllTemplate(int pageNo, int limit, final TemplateQuery query) {
        Pageable pageable = PageRequest.of(pageNo - 1, limit, Sort.by(Sort.Direction.DESC, "createdDt"));
        Page<Template> page = templateRepository.findAll(new Specification<Template>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Template> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

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


                List<Predicate> list = new ArrayList<>();
                Predicate[] predicates = new Predicate[list.size()];
                return criteriaQuery.where(list.toArray(predicates)).getRestriction();
            }
        }, pageable);

        return page;
    }

    /**
     * 插入template数据
     *
     * @param templateDTO templateDTO参数
     * @throws Exception
     */
    public void saveTemplate(TemplateDTO templateDTO) throws Exception {
        Template template = templateDTO.getTemplInstance();

        template.setCreatedDt(new Timestamp(System.currentTimeMillis()));
        templateRepository.save(template);
    }

    /**
     * 更新template数据
     *
     * @param templateId templateId
     * @param template template对象
     * @throws Exception
     */
    public void modifyTemplate(long templateId, Template template) throws Exception {
        template.setId(templateId);
        templateRepository.save(template);
    }

    /**
     * 删除template数据
     *
     * @param templateId 模板ID
     * @throws Exception
     */
    public void deleteTemplate(long templateId) throws Exception {
        templateRepository.deleteById(templateId);
    }
}
