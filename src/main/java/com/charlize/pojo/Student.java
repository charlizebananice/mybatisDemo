package com.charlize.pojo;

public class Student {
    private String sNo;
    private String sName;
    private String sex;
    private int age;
    private String dNo;

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getdNo() {
        return dNo;
    }

    public void setdNo(String dNo) {
        this.dNo = dNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo='" + sNo + '\'' +
                ", sName='" + sName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", dNo='" + dNo + '\'' +
                '}';
    }
}
