package com.stu.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by qixuan on 2017/12/12.
 * 学生成绩实体类
 */

@Entity
@Table(name = "achievement")
public class Achievement implements Serializable {

    private int ano;
    private double chinese; //语文
    private double mathematics; //数学
    private double english; //英语
    private double physics; //物理
    private double chemistry;   //化学
    private double politics;    //政治
    private double history; //历史
    private double geography;   //地理
    private double biology; //生物

    private String identifier; //编号（第几次考试）

    private Stu stu;    //多条成绩对应一个学生

    public Achievement() {
        super();
    }

    public Achievement(int ano, double chinese, double mathematics, double english, double physics, double chemistry, double politics, double history, double geography, double biology, String identifier, Stu stu) {
        this.ano = ano;
        this.chinese = chinese;
        this.mathematics = mathematics;
        this.english = english;
        this.physics = physics;
        this.chemistry = chemistry;
        this.politics = politics;
        this.history = history;
        this.geography = geography;
        this.biology = biology;
        this.identifier = identifier;
        this.stu = stu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMathematics() {
        return mathematics;
    }

    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getPolitics() {
        return politics;
    }

    public void setPolitics(double politics) {
        this.politics = politics;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getGeography() {
        return geography;
    }

    public void setGeography(double geography) {
        this.geography = geography;
    }

    public double getBiology() {
        return biology;
    }

    public void setBiology(double biology) {
        this.biology = biology;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @ManyToOne
    @JoinColumn(name = "sno")
    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }
}
