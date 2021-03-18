package com.Practices.Test0318.StudentManage;

public class Students {
    //编写实体类Students.java

    /**
     * 学生类私有属性：
     * *学号：stuNum;
     * 姓名：stuName;
     * 年龄：stuAge;
     * 生日： stuBirthday;
     * 地址：stuAdress;
     * #学校：stuSchool     ==北上广幼稚园
     * 学生类成员方法：
     * stuLearn();
     */
    private String stuNum;
    private String stuName;
    private String stuAge;
    private String stuBirthday;
    private String stuAdress;
    private static final String stuSchool = "北上广幼稚园";

    public Students(){

    }

    public Students(String stuNum, String stuName, String stuAge, String stuBirthday, String stuAdress) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuBirthday = stuBirthday;
        this.stuAdress = stuAdress;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuAdress() {
        return stuAdress;
    }

    public void setStuAdress(String stuAdress) {
        this.stuAdress = stuAdress;
    }

    public static String getStuSchool() {
        return stuSchool;
    }

    public void stuLearn(){
        System.out.println("专职学习");
    }

    @Override
    public String toString() {
        return //"Students{" +
                "学号='" + stuNum + '\'' +
                ", 姓名='" + stuName + '\'' +
                ", 年龄='" + stuAge + '\'' +
                ", 生日='" + stuBirthday + '\'' +
                ", 地址='" + stuAdress + '\'' +
                ", 学校='" + stuSchool;
    }
}
