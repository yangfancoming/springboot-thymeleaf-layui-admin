package com.chang.service;

import com.chang.repository.SysResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ANdady on 2019/2/23.
 */
@Service
@Transactional
public class SysResService {

    @Autowired
    private SysResRepository resRepository;
}
