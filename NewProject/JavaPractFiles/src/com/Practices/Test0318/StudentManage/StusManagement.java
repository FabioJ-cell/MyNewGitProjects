package com.Practices.Test0318.StudentManage;

import java.util.ArrayList;
import java.util.Scanner;

public class StusManagement {
    public static void main(String[] args) {
        //Enum<String> inputNum = new String[]{"1", "2", "3","4",};
        //在管理文件StusManagement.java中编写主界面并测试
        Scanner sc = new Scanner(System.in);
        ArrayList<Students> stuList = new ArrayList<>();

        loop:
        while (true) {
            // 1. 搭建主界面菜单
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择:");
            String input = sc.next();//创建变量input接收输入数据，作为进入不同分支的判断依据

            switch (input) {
                case "1":
                    //1.添加学生addStuFunction();
                    addStuFunction(stuList);
                    break;
                case "2":
                    //2.删除学生deleteStuFunction();
                    deleteStuFunction(stuList);
                    break;
                case "3":
                    //3.修改信息updateStuFunction();
                    //需要传入待修改学生的学号，首先进行学号审查
                    System.out.println("请输入要修改信息的学生学号：");
                    String updateInfo = sc.next();
                    int num = queryStuNum(stuList, updateInfo);//审核结束，返回索引
                    if(num==-1){
                        System.out.println("输入的学号不存在，请重试！");
                    }else{
                        updateStuFunction(stuList,num);
                    }
                    break;
                case "4":
                    //4.查看信息queryStuFunction();
                    //需要传入查看对象的学号
                    System.out.println("请输入要查看学生的学号：");
                    String sNum=sc.next();
                    //对输入值做简单过滤
                    //利用枚举类型过滤，还得用集合+++++++++++++++++++++++++++++
                    queryStuFunction(stuList,sNum);
                    break;
                case "5":
                    //5.退出程序exitStuFunction();
                    exitStuFunction();
                    break loop;
                default:
                    break;
            }
        }


    }
    //退出系统
    private static void exitStuFunction() {
        System.out.println("感谢您的使用！！么么哒！");
    }
    //删除学生
    private static void deleteStuFunction(ArrayList<Students> stuList) {
        //提示输入学号，按输入学号找到待删除的学生，执行remove操作
        System.out.println("请输入要删除的学生学号：");
        Scanner dsc=new Scanner(System.in);
        String dNum = dsc.next();
        int dele = queryStuNum(stuList, dNum);
        //判断合理性，执行删除操作
        if(dele==-1){
            System.out.println("输入的学号不存在，请重新尝试！");
        }else {
            String deleName = stuList.get(dele).getStuName();
            stuList.remove(dele);
            System.out.println("学生"+deleName+"已经被移除！");
        }
    }
    //更新信息
    private static void updateStuFunction(ArrayList<Students> stuList, int num) {
        //学号审查工作外部已经完成，调用方法的必然是查到了的
        //根据传入的学生索引，对其信息进行提示修改
        Scanner usc=new Scanner(System.in);
        System.out.println("原名："+stuList.get(num).getStuName()+"\t");
        System.out.print("请输入新的姓名：");
        String nName = usc.next();
        System.out.println("原年龄："+stuList.get(num).getStuName()+"\t");
        System.out.print("请输入新的年龄：");
        String nAge = usc.next();
        System.out.println("原生日："+stuList.get(num).getStuName()+"\t");
        System.out.print("请输入新的生日：");
        String nBirth = usc.next();
        System.out.println("原地址："+stuList.get(num).getStuName()+"\t");
        System.out.print("请输入新的地址：");
        String nAdress = usc.next();
        //修改原对象的各个参数
        stuList.get(num).setStuName(nName);
        stuList.get(num).setStuAge(nAge);
        stuList.get(num).setStuBirthday(nBirth);
        stuList.get(num).setStuAdress(nAdress);
        System.out.println("学生"+nName+"的个人信息更新完成！");
    }
    //查询信息
    private static void queryStuFunction(ArrayList<Students> stuList, String sNum) {
        //传入数据有一个学生对象集合，和一个待查询的学生学号
        //首先审核集合当中是否有元素，为空给提示弹出查询，不为空则进行查询
        if(stuList.isEmpty()){
            System.out.println("当前系统中还未添加任何学生，请添加后再尝试！");
        }else {
            //非空，继续查询
            //利用已经实现、且封装了的queryStuNum方法，返回待查学号对应的索引值，找到学生对象，并打印详细信息
            int thread = queryStuNum(stuList, sNum);//定义新变量thread接收索引值
            System.out.println(stuList.get(thread).toString());
        }
    }
    //创建添加方法，为集合中添加学生对象
    private static void addStuFunction(ArrayList<Students> stuList) {
        //提示管理者输入必要信息完成对新建学生对象的初始化。
        Scanner nsc=new Scanner(System.in);
        System.out.println("请输入新学生的学号：");
        String nNum = nsc.next();
        System.out.println("请输入新学生的名字：");
        String nName = nsc.next();
        System.out.println("请输入新学生的年龄：");
        String nAge = nsc.next();
        System.out.println("请输入新学生的生日：");
        String nBirthday = nsc.next();
        System.out.println("请输入新学生的地址：");
        String nAdress = nsc.next();

        //创建新的学生对象，并且初始化之后添加到集合当中
        Students nstu=new Students(nNum,nName,nAge,nBirthday,nAdress);
        stuList.add(nstu);
        if(stuList.contains(nstu)){
            System.out.println("新学生"+nName+"的信息录入完毕！");
        }else {
            System.out.println("信息录入出现问题！请及时修正系统！");
        }
    }

    //编写独立方法queryStuNum();
    public static int queryStuNum(ArrayList<Students> sList, String sNum) {
        //定义一个变量，查询到结果就赋值并返回，注意返回的是对象在集合内的索引值
        int queray = -1;

        //for遍历访问每一个元素，内部进行二次判断
        for (int i = 0; i < sList.size(); i++) {
            //如果访问到的学生对象学号与传入值匹配，更新query变量,否则不做处理返回
            if (sList.get(i).getStuNum().equals(sNum)){
                queray = i;
            }
                
        }
        return queray;
    }
}
