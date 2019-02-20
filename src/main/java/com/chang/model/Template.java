package com.chang.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 模板PO
 * Created by ANdady on 2019/2/12.
 */
@Entity
@Table(name = "demo_template", indexes = {
        @Index(name = "column1_index", columnList = "column1"),
        @Index(name = "column3_column4_column5_comboIndex", columnList = "column3, column4, column5")
})
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;

    private Timestamp createdDt;

    private Timestamp beginDt;
    private Timestamp endDt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Timestamp getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Timestamp createdDt) {
        this.createdDt = createdDt;
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
}
