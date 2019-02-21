package com.chang.param;

import com.chang.model.Template;

import java.sql.Timestamp;

/**
 * Created by ANdady on 2019/2/22.
 */
public class TemplateDTO {

    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;

    private String imagePath;
    private String attachPath;

    private Timestamp beginDt;
    private Timestamp endDt;

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public Timestamp getBeginDt() {
        return beginDt;
    }

    public void setBeginDt(Timestamp beginDt) {
        this.beginDt = beginDt;
    }

    public Timestamp getEndDt() {
        return endDt;
    }

    public void setEndDt(Timestamp endDt) {
        this.endDt = endDt;
    }

    public Template getTemplInstance() {
        Template template = new Template();
        template.setColumn1(this.getColumn1());
        template.setColumn2(this.getColumn2());
        template.setColumn3(this.getColumn3());
        template.setColumn4(this.getColumn4());
        template.setColumn5(this.getColumn5());

        template.setImagePath(this.getImagePath());

        template.setBeginDt(this.getBeginDt());
        template.setEndDt(this.endDt);

        return template;
    }
}
