/*请定义一个交通工具(Vehicle)的类
        其中有属性：
        速度(speed)
        体积(size)等等
        方法移动(move())
        设置速度(setSpeed(int speed))
        加速speedUp(),
        减速speedDown()等等.

        最后在测试类Vehicle中的main()中实例化一个交通工具对象
        并通过方法给它初始化speed,size的值并且打印出来。
        另外调用加速减速的方法对速度进行改变。*/
public class Homework2 {
    public static void main(String[] args) {
        // 通过无参数构造方法创建对象
        Vehicle v = new Vehicle();
        // 通过set方法给属性赋值
        v.setSpeed(0);
        v.setSize(5);

        v.move();

        System.out.println("speed : " + v.getSpeed());
        System.out.println("size : " + v.getSize());

        // 调用加速方法
        v.speedUp(10);
        System.out.println("speed : " + v.getSpeed());

        v.speedUp(30);
        System.out.println("speed : " + v.getSpeed());

        v.speedUp(40);
        System.out.println("speed : " + v.getSpeed());

        // 调用减速方法
        v.speedDown(10);
        System.out.println("speed : " + v.getSpeed());

        v.speedDown(20);
        System.out.println("speed : " + v.getSpeed());

        // 通过有参数的构造方法创建对象
        //Vehicle v1 = new Vehicle(120, 5);
    }
}

/*交通工具*/
class Vehicle {
//    速度
    private int speed;
//    体积
    private int size; // 长度，公交车5米。

    public Vehicle() {
    }

    public Vehicle(int speed, int size) {
        this.speed = speed;
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    /*设置速度的方法*/
    /*实例方法调用，需要先创建对象，通过引用.来调用。*/
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /*交通工具的移动方法*/
    public void move(){
        System.out.println("交通工具：公共汽车，起步行驶。");
    }
    /*加速方法*/
    public void speedUp(int addSpeed){
        // 在原来速度的基础之上加
        // this 就是当前的交通工具对象
        // 安全判断
        int oldSpeed = this.getSpeed(); // 原来的速度
        this.setSpeed(oldSpeed + addSpeed);
    }

    /*减速方法*/
    public void speedDown(int subSpeed){
        // 在原来基础之上减去
        // 最好有判断
        int oldSpeed = this.getSpeed();
        this.setSpeed(oldSpeed - subSpeed);
    }
}
