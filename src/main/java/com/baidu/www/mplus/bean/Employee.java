package com.baidu.www.mplus.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 *
 * @author liuyangos8888
 *
 * 实体类
 * 建议使用封装类型String，Integer，方便框架判空
 *
 */
//@TableName(value = "tbl_employee")
public class Employee implements Serializable {

    /**
     * 字段的ID
     */
//    @TableId(type = IdType.AUTO)
    private Integer id ;

    /**
     * 名字
     */
//    @TableField(value = "last_name")
    private String lastName;

    /**
     * 邮箱
     */
    private String email ;

    /**
     * 性别
     */
    private Integer gender ;

    /**
     * 年龄
     */
    private Integer age ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
