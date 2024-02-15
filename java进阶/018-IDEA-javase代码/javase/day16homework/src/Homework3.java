/*在程序中经常要对时间进行操作但是并没有时间类型的数据。
那么我们可以自己实现一个时间类来满足程序中的需要。

定义名为MyTime的类其中应有三个整型成员时hour分minute秒second
为了保证数据的安全性这三个成员变量应声明为私有。

为MyTime类定义构造方法以方便创建对象时初始化成员变量。
再定义diaplay方法用于将时间信息打印出来。

为MyTime类添加以下方法
	addSecond(int sec)
	addMinute(int min)
	addHour(int hou)
	subSecond(int sec)
	subMinute(int min)
	subHour(int hou)
分别对时、分、秒进行加减运算。*/
public class Homework3 {
    public static void main(String[] args) {
        MyTime t1 = new MyTime();
        t1.display();

        MyTime t2 = new MyTime(13, 20, 50);
        t2.display();

        t2.addSecond(5);
        t2.display();

        t2.addSecond(6);
        t2.display();

        t2.addSecond(50);
        t2.display();

        t2.addSecond(9);
        t2.display();

        t2.addSecond(121);
        t2.display();

        t2.setMinute(59);
        t2.display();

        t2.addSecond(60);
        t2.display();

        /*最主要锻炼的是：set方法是用来修改对象属性的值，get方法是用来获取对象属性的值。*/
    }
}

class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    // 这个题目最主要锻炼set和get方法
    // 你要知道set方法就是赋值。get方法就是读取。
    /*加秒*/
    public void addSecond(int sec){
        // 在原来秒基础之上再加秒
        //this.setSecond(this.getSecond() + sec);
        // 再往下的内容和编程还有关系吗？没有，和数学有关系。
        int oldSec = this.getSecond();
        int newSec = oldSec + sec;
        if(newSec < 60){
            // 总的秒数少于60
            this.setSecond(newSec);
        }else if(newSec == 60){
            // 总的秒数正好是60
            this.addMinute(1); // 加分钟。
            this.setSecond(0); // 秒归0
        }else{
            // 总的秒数大于60
            // 可能是61,也可能是121
            int newMinute = newSec / 60; // 121 / 60 = 2
            this.addMinute(newMinute);
            this.setSecond(newSec % 60);
        }
    }
    /*加分*/
    public void addMinute(int min){
        // 加分钟的方法。
        int oldMinute = this.getMinute();
        int newMinute = oldMinute + min;
        // 这里没有处理：因为分钟满60，小时应该加1
        this.setMinute(newMinute);
    }
    /*加时*/
    public void addHour(int hou){

    }
    /*减秒*/
    public void subSecond(int sec){

    }
    /*减分*/
    public void subMinute(int min){

    }
    /*减时*/
    public void subHour(int hou){

    }

    /*set方法就是为了修改。get方法就是为了获取。*/
    public void display(){
        //System.out.println(this.hour + "时" + this.minute + "分" + this.second + "秒");
        System.out.println(this.getHour() + "时" + this.getMinute() + "分" + this.getSecond() + "秒");
    }
}
