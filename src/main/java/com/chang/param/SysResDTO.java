package com.chang.param;

import com.chang.model.SystemResource;

/**
 * Created by EDZ on 2019/3/1.
 */
public class SysResDTO {

    private String code;
    private String name;
    private String type;
    private String matchUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatchUrl() {
        return matchUrl;
    }

    public void setMatchUrl(String matchUrl) {
        this.matchUrl = matchUrl;
    }

    public SystemResource getSysResInstance() {
        SystemResource resource = new SystemResource();
        resource.setCode(this.getCode());
        resource.setName(this.getName());
        resource.setType(this.getType());
        resource.setMatchUrl(this.getMatchUrl());

        return resource;
    }

    public void transfer(SystemResource resource) {
        resource.setCode(this.getCode());
        resource.setName(this.getName());
        resource.setType(this.getType());
        resource.setMatchUrl(this.getMatchUrl());
    }
}
