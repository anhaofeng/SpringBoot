package com.imooc.girl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class GirlHbm {
    @Id
    @GeneratedValue
    private  int id;
    @Min(value = 5,message = "未成年少女禁止入内")
    private  int age;
    private  String cupSize;
    @NotNull(message = "金额必穿")
    private  double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public GirlHbm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    @Override
    public String toString() {
        return "GirlHbm{" +
                "id=" + id +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                ", money=" + money +
                '}';
    }
}
