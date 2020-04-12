package finallTest;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        User tu = new User();
        Student stu = new Student();
        stu.collection();
        //选择是否注册用户否则登陆用户输入正确的用户名和密码
           System.out.println("是否注册用户");
           Scanner sc = new Scanner(System.in);
           String s =sc.next();
           if(s.equals("y")){
               tu.collection();
               tu.adduser();
           }else {                       //登陆后选择需要的操作
               System.out.println("请输入用户名和密码：");
               int ll = tu.denlu();
               if (ll == 1) {
                   System.out.println("请输入您要进行的操作");
                   Scanner work = new Scanner(System.in);
                   String gg = work.next();
                   if (gg.equals("1")) {
                       Scanner su = new Scanner(System.in);
                       Student fg = new Student();
                       System.out.println("请输入学号");
                       String studentnumber = su.next();
                       System.out.println("请输入姓名");
                       String studentname = su.next();
                       System.out.println("请输入身份证号");
                       String IDnumber = su.next();
                       System.out.println("请输入专业");
                       String study = su.next();
                       System.out.println("请输入班级");
                       String classname = su.next();
                       System.out.println("请输入籍贯");
                       String nativeplace = su.next();
                       System.out.println("请输入家庭地址");
                       String adress = su.next();
                       System.out.println("请输入成绩");
                       String grade =  su.next();
                       fg.add(studentnumber, studentname, IDnumber, study,classname,
                               nativeplace, adress, grade);
                       stu.addstudent(fg);
                   }
                   if (gg.equals("2")) {
                       stu.collection();
                       System.out.println("请输入要删除的学生学号");
                       Scanner hao = new Scanner(System.in);
                       String number = hao.next();
                       stu.deletestudent(number);
                   }
                   if(gg.equals("3")){
                       stu.collection();
                       Scanner mm = new Scanner(System.in);
                       System.out.println("请输入该学生学号");
                       String number= mm.next();
                       System.out.println("请输入要修改的信息");
                       String gai = mm.next();
                       System.out.println("请输入要修改的内容");
                       String nei = mm.next();
                       stu.change(number,gai,nei);
                   }
                   if(gg.equals("4")){
                       System.out.println("请输入要查找学生学号：");
                       Scanner vv = new Scanner(System.in);
                       Student stt = new Student();
                       stt=stu.select(vv.next());
                       System.out.println(stt.studentnumber+" "+stt.studentname+" "+stt.IDnumber+stt.study+" "+stt.classname+" "+stt.nativeplace
                               +" "+stt.adress+" "+stt.grade);
                   }
                   if(gg.equals("5")){
                       stu.collection();
                       stu.showgrade();
                   }
                   if(gg.equals("6")){
                       stu.collection();
                       stu.showstudy();
                   }
               }
           }
    }
}
