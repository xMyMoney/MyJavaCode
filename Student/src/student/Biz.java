package student;

import java.util.ArrayList;

public class Biz {

    /*
    添加学生
     */
    public boolean addStudent(Student stu) {
        if (stu == null) {
            return false;
        }
        Data.list.add(stu);
        return true;
    }

    /*
    删除学生
     */
    public boolean delStudent(Student stu) {
        int index = Data.list.indexOf(stu);
        if (index != -1) {
            Data.list.remove(index);
            return true;
        }
        return false;
    }

    /*
    修改学生
     */
    public void chStudent(int index, Student stu) {
        Data.list.set(index,stu);
    }

    /*
    查找学生
     */
    public Student findStudent(String s) {
        if (s == null) {
            return null;
        }
        for (Student stu : Data.list
        ) {
            if (s.equals(stu.getName())) {
                return stu;
            }
            if (s.equals(stu.getId())) {
                return stu;
            }
        }
        return null;
    }
}
