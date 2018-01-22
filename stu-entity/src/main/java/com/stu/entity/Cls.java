package com.stu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by qixuan on 2017/12/12.
 * 班级实体类
 */

@Entity
@Table(name = "cls")
public class Cls implements Serializable {

    private int cno;
    private String cname;

    private String cslogan; //口号

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date classBegin; //开班时间

    public Cls() {
        super();
    }

    public Cls(int cno, String cname, String cslogan, Date classBegin) {
        this.cno = cno;
        this.cname = cname;
        this.cslogan = cslogan;
        this.classBegin = classBegin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCslogan() {
        return cslogan;
    }

    public void setCslogan(String cslogan) {
        this.cslogan = cslogan;
    }

    @Column(columnDefinition = "date")
    public Date getClassBegin() {
        return classBegin;
    }

    public void setClassBegin(Date classBegin) {
        this.classBegin = classBegin;
    }
}
