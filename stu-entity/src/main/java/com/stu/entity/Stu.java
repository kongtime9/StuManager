package com.stu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by qixuan on 2017/12/6.
 * 学生实体类
 */

@Entity
@Table(name = "stu")
public class Stu implements Serializable {

    private int sno;    //学号
    private String sname;   //姓名
    private int sage = 18;   //年龄   默认为18
    private int ssex = 1;   //性别 默认为1：男，0：女
    private String saddress;    //地址
    private String stel;    //联系电话
    private String simage;  //图像

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date senrolmenttime;    //入学时间

    private Cls cls;    //多个学生对应一个班级

    public Stu() {
        super();
    }

    public Stu(int sno, String sname, int sage, int ssex, String saddress, String stel, String simage, Date senrolmenttime) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.saddress = saddress;
        this.stel = stel;
        this.simage = simage;
        this.senrolmenttime = senrolmenttime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getSsex() {
        return ssex;
    }

    public void setSsex(int ssex) {
        this.ssex = ssex;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = "user.jpg";

        if(simage != null && simage.length() > 0){
            this.simage = simage;
        }
    }

    @Column(columnDefinition = "date")
    public Date getSenrolmenttime() {
        return senrolmenttime;
    }

    public void setSenrolmenttime(Date senrolmenttime) {
        this.senrolmenttime = senrolmenttime;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cno")
    public Cls getCls() {
        return cls;
    }

    public void setCls(Cls cls) {
        this.cls = cls;
    }
}
