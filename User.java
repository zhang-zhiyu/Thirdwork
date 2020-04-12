package finallTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    public String name;//用户姓名
    public String pwd;//用户密码
    static List<User> u = new ArrayList<User>();//用户集合
    static int count=0;
    public void add(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }
    //从文件里收集用户信息
    public void collection(){
        count=0;
        try {
            File file = new File("D:\\user1.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bre = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
            String gg = null;
            String str = "";
            while ((gg = bre.readLine()) != null) {
                str = gg;
               // System.out.println(str);
                count++;
                //System.out.println(count);
                String[] k = str.split(" ");
                User tt = new User();
                tt.add(k[0], k[1]);
                u.add(tt);
            }
            bre.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //增加用户
    public void adduser(){
        User t = new User();
        //System.out.println(count);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        t.name=sc.next();
        System.out.println("请输入密码：");
        t.pwd=sc.next();
        count++;
        //System.out.println(count);
        u.add(t);
        try {
           // File file = new File("D:\\user.txt");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("D:\\user1.txt")), "GBK");
            BufferedWriter  bw = new BufferedWriter(writer);
            for(int i=0;i<count;i++){
                String uu = u.get(i).name+" "+u.get(i).pwd+"\r\n";
                //System.out.println(uu);
                bw.write(uu);
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //用户登录方法
    public int denlu() {
        int flge = 0;
        try {
            File file = new File("D:\\user1.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bre = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
            String gg = null;
            String str = "";
            for (int i = 0; i < 3; i++) {
                 flge = 0;
                Scanner sc = new Scanner(System.in);
                String jj = sc.next();
                String kk = sc.next();
                while ((gg = bre.readLine()) != null) {
                    str = gg;
                    //System.out.println(str);
                    String[] k = str.split(" ");
                    if ((jj.equals(k[0])) && (kk.equals(k[1]))) {
                        System.out.println("欢迎登陆");
                        flge = 1;
                        break;
                    }
                }
                if (flge == 0) {
                    System.out.println("用户名或密码错误");
                } else {
                    break;
                }
            }
            bre.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  flge;
    }
}
