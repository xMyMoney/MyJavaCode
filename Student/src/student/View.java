package student;

import java.util.Scanner;

public class View {
    Scanner input = new Scanner(System.in);
    Biz biz = new Biz();

    /*
    菜单
     */
    public void showMenu() {
        System.out.println("学生成绩管理系统");
        System.out.println("\t\t------------------------");
        System.out.println("\t\t\t1.查看所有学生");
        System.out.println("\t\t\t2.添加学生");
        System.out.println("\t\t\t3.查找学生");
        System.out.println("\t\t\t4.删除学生");
        System.out.println("\t\t\t5.修改学生");
        System.out.println("\t\t\t6.退出");
    }

    /*
    选择操作界面
     */
    public void choose() {
        boolean flag = true;
        while (flag) {
            showMenu();
            int i = input.nextInt();
            switch (i) {
                case 1:
                    showAll();
                    break;
                case 2:
                    showAdd();
                    break;
                case 3:
                    showFind();
                    break;
                case 4:
                    showDel();
                    break;
                case 5:
                    showChange();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }
    }

    /*
    查看所有学生
     */
    public void showAll() {
        System.out.println("姓名" + "\t学号" + "\t性别" + "\t年龄");
        for (Student stu : Data.list
        ) {
            System.out.println(stu.getName() + "\t\t" + stu.getId() + "\t\t" + stu.getSex() + "\t\t" + stu.getAge());
        }
    }

    /*
    添加学生
     */
    public void showAdd() {
        Student stu = new Student();
        System.out.println("请输入学生姓名:");
        stu.setName(input.next());
        System.out.println("请输入学生学号:");
        stu.setId(input.next());
        System.out.println("请输入学生性别:");
        stu.setSex(input.next());
        System.out.println("请输入学生年龄:");
        stu.setAge(input.nextInt());
        if (biz.addStudent(stu)) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    /*
    查找
     */
    public Student find(){
        Student stu = biz.findStudent(input.next());
        if (stu != null) {
            System.out.println("找到了！");
            System.out.println("姓名" + "\t学号" + "\t性别" + "\t年龄");
            System.out.println(stu.getName() + "\t\t" + stu.getId() + "\t\t" + stu.getSex() + "\t\t" + stu.getAge());
        } else {
            System.out.println("未找到该生！");
        }
        return stu;
    }

    /*
    查找学生
     */
    public void showFind() {
        System.out.println("请输入要查找的学生姓名或学号:");
       find();
    }

    /*
    删除学生
     */
    public void showDel() {
        System.out.println("请输入要删除的学生姓名或学号:");
        Student stu=find();
        System.out.println("删除请按1 返回按0");
        int i = input.nextInt();
        switch (i) {
            case 1:
                if (biz.delStudent(stu)) {
                    System.out.println("删除成功！");
                } else {
                    System.out.println("删除失败！");
                }
                break;
            case 0:
                System.out.println("暂不删除！");
                break;
            default:
                break;
        }
    }

    /*
    修改学生
     */
    public void showChange(){
        System.out.println("请输入要修改的学生姓名或学号:");
        Student oldStu=find();
        int index=Data.list.indexOf(oldStu);
        System.out.println("\t1.修改姓名");
        System.out.println("\t2.修改学号");
        System.out.println("\t3.修改性别");
        System.out.println("\t4.修改年龄");
        System.out.println("\t5.返回");
        System.out.println("请选择:");
        int i=input.nextInt();
        switch (i){
            case 1:
                System.out.println("请输入新的姓名:");
                oldStu.setName(input.next());
                biz.chStudent(index,oldStu);
                break;
            case 2:
                System.out.println("请输入新的学号:");
                oldStu.setId(input.next());
                biz.chStudent(index,oldStu);
                break;
            case 3:
                System.out.println("请输入新的性别:");
                oldStu.setSex(input.next());
                biz.chStudent(index,oldStu);
                break;
            case 4:
                System.out.println("请输入新的年龄:");
                oldStu.setAge(input.nextInt());
                biz.chStudent(index,oldStu);
                break;
            default:
                break;
        }
    }
}
