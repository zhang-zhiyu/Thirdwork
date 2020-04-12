package finallTest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Student {
    public String studentnumber;//学生学号
    public String studentname;//学生姓名
    public String IDnumber;//学生身份证号
    public String study;//学生选修的专业
    public String classname;//学生所在的班级
    public String nativeplace;//学生的籍贯
    public String adress;//学生的家庭地址
    public String grade;//学生的成绩
    static int count = 0;
    static List<Student> user = new ArrayList<Student>();//学生集合
    public void add(String studentnumber, String studentname, String IDnumber, String study, String classname,
                    String nativeplace, String adress, String grade) {
        this.studentnumber = studentnumber;
        this.studentname = studentname;
        this.IDnumber = IDnumber;
        this.study = study;
        this.classname = classname;
        this.nativeplace = nativeplace;
        this.adress = adress;
        this.grade = grade;
    }

    //从文件中收集学生信息
    public void collection() {
        count =0;
        try {
            File file = new File("D:\\student1.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bre = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
            String gg = null;
            String str = "";
            while ((gg = bre.readLine()) != null) {
                str = gg;
                //System.out.println(str);
                count++;
                String[] k = str.split(" ");
                Student t = new Student();
                t.add(k[0], k[1], k[2], k[3], k[4], k[5], k[6], k[7]);
                //System.out.println(t.adress);
                user.add(t);
            }
            bre.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //增加学生信息
    public void addstudent(Student fg) {
        user.add(fg);
        count++;
        try {
            //File file = new File("D:\\student.txt");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("D:\\student1.txt")), "GBK");
          BufferedWriter  bw = new BufferedWriter(writer);
            for (int i = 0; i < count; i++) {
                String ww = "";
                ww = user.get(i).studentnumber + " " + user.get(i).studentname + " " + user.get(i).IDnumber + " " + user.get(i).study + " " +
                        user.get(i).classname + " " + user.get(i).nativeplace + " " + user.get(i).adress + " " + user.get(i).grade + "\r\n";
                bw.write(ww);
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //删除某一学生所有信息
    public void deletestudent(String number){
        int hao=0;
        for(int i=0;i<count;i++){
            if(user.get(i).studentnumber.equals(number)){
                hao=i;
            }
        }
        user.remove(hao);
        count--;
        try {
            //File file = new File("D:\\student.txt");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("D:\\student1.txt")), "GBK");
            BufferedWriter  bw = new BufferedWriter(writer);
            for (int i = 0; i < count; i++) {
                String ww = "";
                ww = user.get(i).studentnumber + " " + user.get(i).studentname + " " + user.get(i).IDnumber + " " + user.get(i).study + " " +
                        user.get(i).classname + " " + user.get(i).nativeplace + " " + user.get(i).adress + " " + user.get(i).grade + "\r\n";
               // System.out.println(ww);
                bw.write(ww);
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //修改某学生的任意信息
    public void change(String number,String gai,String nei) {
        int hhh = 0;
        for (int i = 0; i < count; i++) {
            if (number.equals(user.get(i).studentnumber)) {
                hhh = i;
                //System.out.println(hhh);
            }
        }
        String ww = "";
        if (gai.equals("studentnumber")) {
            ww = nei + " " + user.get(hhh).studentname + " " + user.get(hhh).IDnumber + " " + user.get(hhh).study + " " +
                    user.get(hhh).classname + " " + user.get(hhh).nativeplace + " " + user.get(hhh).adress + " " + user.get(hhh).grade + "\r\n";
        }
        if (gai.equals("studentname")) {
            ww = user.get(hhh).studentnumber + " " +nei + " " + user.get(hhh).IDnumber + " " + user.get(hhh).study + " " +
                    user.get(hhh).classname + " " + user.get(hhh).nativeplace + " " + user.get(hhh).adress + " " + user.get(hhh).grade + "\r\n";
        }
        if (gai.equals("IDnumber")) {
            ww = user.get(hhh).studentnumber + " " + user.get(hhh).studentname + " " + nei+ " " + user.get(hhh).study + " " +
                    user.get(hhh).classname + " " + user.get(hhh).nativeplace + " " + user.get(hhh).adress + " " + user.get(hhh).grade + "\r\n";
        }
        if (gai.equals("study")) {
            ww = user.get(hhh).studentnumber + " " + user.get(hhh).studentname + " " + user.get(hhh).IDnumber + " " + nei + " " +
                    user.get(hhh).classname + " " + user.get(hhh).nativeplace + " " + user.get(hhh).adress + " " + user.get(hhh).grade + "\r\n";
        }
        if(gai.equals("classname")){
            ww = user.get(hhh).studentnumber + " " + user.get(hhh).studentname + " " + user.get(hhh).IDnumber + " " + user.get(hhh).study + " " +
                    nei + " " + user.get(hhh).nativeplace + " " + user.get(hhh).adress + " " + user.get(hhh).grade + "\r\n";
        }
        if(gai.equals("nativeplace")){
            ww = user.get(hhh).studentnumber + " " + user.get(hhh).studentname + " " + user.get(hhh).IDnumber + " " + user.get(hhh).study + " " +
                    user.get(hhh).classname + " " + nei + " " + user.get(hhh).adress + " " + user.get(hhh).grade + "\r\n";
        }
        if(gai.equals("adress")){
            ww =  user.get(hhh).studentnumber + " " + user.get(hhh).studentname + " " + user.get(hhh).IDnumber + " " + user.get(hhh).study + " " +
                    user.get(hhh).classname + " " + user.get(hhh).nativeplace + " " + nei + " " + user.get(hhh).grade + "\r\n";
        }
        if(gai.equals("grade")){
            ww =user.get(hhh).studentnumber + " " + user.get(hhh).studentname + " " + user.get(hhh).IDnumber + " " + user.get(hhh).study + " " +
                    user.get(hhh).classname + " " + user.get(hhh).nativeplace + " " + user.get(hhh).adress + " " + nei + "\r\n";
            System.out.println(ww);
        }
        user.remove(hhh);
        try {
            //File file = new File("D:\\student.txt");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("D:\\student1.txt")), "GBK");
            BufferedWriter  bw = new BufferedWriter(writer);
            for (int i = 0; i < count; i++) {
                if(i!=hhh){
                    String kk="";
                    kk = user.get(i).studentnumber + " " + user.get(i).studentname + " " + user.get(i).IDnumber + " " + user.get(i).study + " " +
                            user.get(i).classname + " " + user.get(i).nativeplace + " " + user.get(i).adress + " " + user.get(i).grade + "\r\n";
                    //System.out.println(kk);
                    bw.write(kk);
                }else{
                    //System.out.println(ww);
                    bw.write(ww);
                }

            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //按学号查找某一学生的全部信息
    public Student select(String number){
        int oo =0;
        for(int i=0;i<count;i++){
            if(user.get(i).studentnumber.equals(number)){
                oo=i;
            }
            }
        return  user.get(oo);
        }
        public void showgrade(){
           String[] name = new String[user.size()];
           int[] gd = new int[user.size()];
           for(int i=0;i<count;i++){
               name[i]=user.get(i).studentname;
               gd[i]=Integer.parseInt(user.get(i).grade);
           }
           for(int i=0;i<name.length-1;i++){
                 int max=i;
                 for(int j=i+1;j<name.length;j++){
                     if(gd[max]<gd[j]){
                         max=j;
                     }
                 }
                 if(max!=i){
                     int temp=gd[i];
                     gd[i]=gd[max];
                     gd[max]=temp;
                     String ch=name[i];
                     name[i]=name[max];
                     name[max]=ch;
                 }
           }
           System.out.println("姓名 成绩");
           for(int q=0;q<count;q++){
               System.out.println(name[q]+" "+gd[q]);
           }
        }
        //查看文件里所有学生的学习成绩由高到低
        public void showstudy(){
        int bujige=0;
        int jige=0;
        int zhongdeng=0;
        int lianghao=0;
        int youxiu=0;
        for(int i=0;i<count;i++)
        {
            if((Integer.parseInt(user.get(i).grade))>=0&&(Integer.parseInt(user.get(i).grade))<=59){
                bujige++;
            }
            if((Integer.parseInt(user.get(i).grade))>=60&&(Integer.parseInt(user.get(i).grade))<=69){
                jige++;
            }
            if((Integer.parseInt(user.get(i).grade))>=70&&(Integer.parseInt(user.get(i).grade))<=79){
                zhongdeng++;
            }
            if((Integer.parseInt(user.get(i).grade))>=80&&(Integer.parseInt(user.get(i).grade))<=89){
                lianghao++;
            }
            if((Integer.parseInt(user.get(i).grade))>=90&&(Integer.parseInt(user.get(i).grade))<=100){
                youxiu++;
            }
        }
            System.out.println("0-59:"+bujige);
            System.out.println("60-69:"+jige);
            System.out.println("70-79:"+zhongdeng);
            System.out.println("80-89:"+lianghao);
            System.out.println("90-100:"+youxiu);
        }
    }

