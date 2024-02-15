

#  JAVA笔记

### 发展史

JAVA EE  （淘汰）--- 平台企业版

 JAVA ME （淘汰）--- 平台微型版

JAVA SE（Java标准版）

#### 关键术语

- JDK---JAVA开发工具箱

- JRE---JAVA运行时的环境

- JVM---JAVA虚拟机

- 三者关系：JDK包含JRE、JRE包含JVM

  

### 特点

#### 跨平台、可移植

- 特殊机制：JVM
- Java程序没有直接跟os交互，Java程序实际运行在JVM中，屏蔽了os之间的差异
- 一次编译，到处运行
- 必须提前安装JRE，有了JRE才有JVM虚拟机

#### 开源免费、面向对象

#### 简单性

- 简单是针对C语言的，比如C语言有指针，C++中有多继承，java取消了指针的概念，只支持**单继承**

#### 支持多线程

#### 特殊机制：自动垃圾回收机制，GC机制



### Java的加载和执行

#### 编译和运行

- 编译生成字节码程序，生成.class文件
- 编译和运行可以在不同的os中完成

##### 编译过程：

1. 安装JDK，配置环境
2. 创建.java文件
3. 使用JDK自带的**javac.exe**命令对java源程序进行编译

##### 运行过程：

1. 可以在**不同os**上运行，但前提是已经配置好java的运行环境
2. 在命令窗口使用**java.exe命令**运行java程序，格式为：**java 类名**，eg：java hello
3. 启动JVM，启动**类加载器-Class Loader**，开始去找.class文件，找到后将该文件转化为二进制，os可以直接识别二进制

##### 执行java hello的原理

1. java.exe命令启动JVM虚拟机
2. 虚拟机启动后会启动类加载器Classloader
3. Classloader会去搜索加载xxx.class字节码文件
4. 找到后执行，找不到报错



### Java源程序注释

- 单行注释 //
- 多行注释 /*   */
- **javadoc注释** /**	**/	（这种注释是比较专业的注释，会被javadoc.exe工具解析提取并生成**帮助文档**）



### public class 和 class的区别

#### 类的定义：

- public class类名（文件名必须和类名一致）
- class类名

一个java文件可以有多个class，但只能有一个public class



### Java程序内容

#### 标识符

![image-20231101112105543](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231101112105543.png)

#### 关键字

关键字都是小写的

![image-20231101144609763](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231101144609763.png)

![image-20231101144629060](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231101144629060.png)

#### 数据类型

byte、short、int、long、float、double、char、boolean

#### 变量

- 整数型
- 浮点型float/double，默认double，指明float型时格式要带上f，eg：float a=10.5f;
- 布尔型 boolean flag=true;

#### 基本类型转换

- 除了boolean比较特殊不可以转换成其他类型
- 默认转换：byte-》short-》int-》long-》float-》double
- 强制转换

#### 运算符![image-20231101150958355](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231101150958355.png)

#### 控制语句

- 控制选择结构：if、if else、switch
- 控制循环：for、while、do while
- 改变控制语句顺序：break、continue



### 代码注意

#### 无法在static 函数中直接调用类的私有成员和私有变量

##### 解决方法

```java
//实例化类对象
public static void main(String[] args){
	CharTest ch = new CharTest();
	System.out.println(ch.compute(5));
}
private int compute(int n){
	int s=1;
	for(int i=1;i<=n;i++){
		s*=i;
	}
	return s;
}

//声明为静态方法
public static void main(String[] args){
	//CharTest ch = new CharTest();
	System.out.println(compute(5));
}
static int compute(int n){
	int s=1;
	for(int i=1;i<=n;i++){
		s*=i;
	}
	return s;
}
```





### 面向过程 && 面向对象

#### 面向对象三大特性

- **封装**：把实体的属性和功能相结合，形成一个整体。隐藏我想要保护的对象属性和实现细节，仅对外公开接口。意义：隐藏实体实现的细节、提高安全性、简化编程
- **继承**：在原来的类的基础上对功能进行扩展，意义：减少代码的冗余，为多态打下基础
- **多态**：指一个类的同名方法，在不同情况下的实现细节不同，不同的内部实现结构共用一个外部接口。

##### 类=属性+方法



### 类的定义

```java
修饰符 class 类名 extends 父对象名称 implements 接口名称{
	类体：属性+方法
}

eg：
public class student{
    int id;
    int age;
    String name;
    void getAge(){
        return self.age;
	}
}
```



### 对象的创建和使用

必须要使用new关键字

```java
public class Test{
	public static void main(String[] args){
		Student stu = new Student();
        stu.id=101;
        stu.name="zhangsan";
        stu.sex=1;
        stu.address="beijing"
        stu.age=20;
        System.out.println("id="+stu.id);
    }
}
class Student {
	int id;
	String name;
	boolean sex;
	String address;
	int age;
}
```



### 面向对象的封装性

控制对内部状态的读取权利，**封装属性，暴露方法**

```java
public class Test{
	public static void main(String[] args){
		Student stu = new Student();
        stu.setID(1012);
        stu.setName("wang");
        stu.setAge(2131);

        System.out.println(stu.getID());
    }
}
class Student {
	private int id;
	private String name;
	private int age;

	public void setID(int id){
		this.id=id;
	}
	public int getID(){
		return id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	
}
```



### 构造函数

 构造函数用来实例化对象，格式：**类名+参数列表**，可以用public、protected、private修饰

#### 特点：

- 构造方法与类名相同
- 没有返回值，不需要加入void关键字（如果加入，则就变成了普通的方法）
- 如果显示地定义了构造函数，则系统不会创建默认构造器

```java
Class student{
	private int id;
	private int age;
    
	//手动定义
	pubilc Stduent(int id,int age){
		this.id=id;
		this.age=age;
	}
    //可以重载
    public Student(){
        this.id=0;
        this.age=0;
    }
}
```



### 重载和重写的区别

#### 重写

重写是子类对父类中**允许访问的方法**进行重新编写，**返回值**和**形参**都不能改变，即**外壳不变、核心重写**。

**注意：**

- 使用super关键字调用父类的被重写方法
- 声明为final、static的方法不能被重写
- 访问权限不能比父类中被重写的方法更低，如父类重视public，子类重写该方法就不能为protected
- 构造方法不能被重写



#### 重载

重载是在一个类里面，方法名字相同，参数不同，返回类型可以相同也可以不同。



### 对象和引用

#### Java内存的主要划分

只要是**基本类型**都是**值传递**，除了基本类型都是**引用传递**（如类、数组、String）

#### JVM内存结构和Java内存模型

内存结构大致分为：

- **堆**：线程共享。存放所有的对象实例以及数组都要在堆上分配。也是回收器主要管理的对象
- **方法区**：线程共享。存储类信息、常量、静态变量、即时编译器编译后的代码
- **方法栈**：线程私有。存储局部变量表、op栈、动态链接、方法出口、对象指针等
- **本地方法栈**：线程私有。为虚拟机使用到的native方法服务。如java使用c或c++编写的接口服务时
- **程序计数器**：线程私有。指向下一条要执行的指令。



### this关键字

**this关键字**指的是当前调用的对象，可以使用在：

- 局部变量与成员变量重名时可以使用this制定调用成员变量
- 通过this调用另外一个构造方法
- 在构造方法中，如果使用this方法调用和其他构造方法，this预取必须放在第一句，否则会发生编译错误

**注意：this只能用于构造函数和成员方法内部，static标识的方法里是不能使用this的**



### Static关键字

#### static可以修饰变量、方法和代码块

- 用static修饰的变量和方法，可以采用类名直接访问（也可以使用对象访问）
- static声明的代码块为静态代码块，**JVM加载类的时候，会执行静态代码块中的内容**



#### 静态方法中不能直接调用实例变量、实例方法和使用this的

```java
//错误示例：
public class Test{
	public static void main(String[] args){
        method();
	}
    public void method(){
        System.out.println("method");
	}
}

//正确示例1
public class Test{
	public static void main(String[] args){
        Test t = new Test();
        Test.method();
	}
    public void method(){
        System.out.println("method");
	}
}
//正确示例2
public class Test{
	public static void main(String[] args){
        method();
        Test.method();
	}
    public static void method(){
        System.out.println("method");
	}
}
```



#### 静态方法的初始化顺序

static声明的变量或static语句在类加载时就会初始化，而且只初始化一次



#### 解释main方法

- public全局所有，其实就是封装性
- static静态的，描述的方法只能通过类调用
- main系统规定的
- String[] args参数类型也是系统规定的

**注意：静态方法不能直接访问成员属性和成员方法**



### 单例模式

#### 设计模式：可以重复利用的解决方案

- 创建型
- 结构型
- 行为型

#### 单例模式

只会创建一个实例，显著减少对象实例的个数，同时提高性能，不会频繁的创建对象

##### 单例模式三要素

- 类体中需要具有静态的私有的本类型变量
- 构造方法必须是私有的
- 提供一个公共的静态入口方法

```java
public class Test{
	public static void main(String[] args) {
		Test01.getInstance().print();
	}
}
class Test01{
	private static Test01 instance = new Test01();
	private Test01(){

	}
	public static Test01 getInstance(){
		return instance;
	}
	public void print() {
		System.out.println("----------test----------");
	}
}
```



### 类的继承

- 继承是实现**软件可重用性**的重要手段
- java只支持**类的单继承**
- 使用extends关键词，格式： class 子类 extends 父类{}

#### 为什么要继承？

- 继承可以让代码实现共享，可以提高代码的重用性。
- 子类可以形似父类，也可以异于父类，让代码的可扩展性提高，框架中的扩展接口都是通过继承父类实现的





### 方法的覆写override

#### 重载overload

- **方法名称相同**，**方法参数类型、个数、顺序**至少有一个不同
- 方法重载只出现在**同一个类中**

#### 重写Override

- 必须要有**继承关系**
- 覆盖只能出现在子类中，如果没有继承关系，不存在覆盖，只存在**重载**
- 子类方法不能抛出比父类方法更多的异常，但可以抛出父类方法异常的子异常
- 覆盖是针对**成员方法**，而非**属性**



### Super关键字

#### super的作用

- 调用父类的构造方法
- 调用父类的成员方法

**注意**：super只能应用在成员方法和构造方法中，不能应用在**静态方法**中，**如果在构造方法中使用必须放在第一行**

```java
class Person{
	int id;
    String name;
    public Person(){
        System.out.println("Hi,person");
	}
    public void say(){
         System.out.println("My name is "+name);
	}
}
class Student extends Person{
    int score;
    public Student(){
        //super调用父类构造函数要放在第一行
        super();
        System.out.println("Hi,student");
	}
    public void printInfo(){
        super.say();
        System.out.println("My name is "+score);
	}
}

```

**注意：**在本次代码编写发现了一点小错误，将构造函数设置为private会导致super无法调用父类的构造函数



### final关键字

#### final表示不可改变的含义

- **final修饰的类不能被继承，final修饰的方法不能被覆盖，final修饰的变量不能被修改，final修饰的变量必须显示初始化**
- 如果修饰的引用，那么这个引用只能指向一个对象
- 构造方法不能被final修饰
- 会影响Java类的初始化，**final定义的静态变量调用时不会执行java的类初始化方法**，也就是说不会执行static代码块等相关语句（这是由java虚拟机规定的）

```java
//！！！！！下面是错误示例！！！！！
//1.final修饰的类不能被继承
final class A1{
	public void test1(){}
}
class B1 extends A1{
	public void test2(){}
}


//2.final修饰的方法不能被覆盖
class A1{
	public final void test1(){
	}
}
class B1 extends A1{
	public void test1(){

	}
}

//3.final修饰的变量不能被修改
public class FinalTest03 {
	private static final long CARD_NO = 878778878787878L;
	public static void main(String[] args) {
		//不能进行修改，因为 CARD_NO 采用 final 修改了
		CARD_NO = 99999999999999L;
	}
}

//4.final修饰的变量必须显示初始化
class A1{
	private final int num;
	public final void test1(){
	}
}

//5.如果修饰的是引用，那么引用只能指向一个对象
Person p1 = new Person();
//可以赋值
p1.name = "张三";
System.out.println(p1.name);
final Person p2 = new Person();
p2.name = "李四";
System.out.println(p2.name);
//不能编译通过
//p2 采用 final 修饰，主要限制了 p2 指向堆区中的地址不能修改(也就是 p2 只能指向一个对象)
//p2 指向的对象的属性是可以修改的
p2 = new Person();
```



### 抽象类

- 使用**abstract关键字**修饰
- 抽象的方法只需在抽象类中提供声明，不需要实现
- 如果这个类是抽象的，那这个类**被子类继承**，抽象方法必须被**复写**。如果在子类中不复写该抽象方法，那么必须将此方法**再次声明为抽象方法**
- 抽象的类是不能实例化的（eg：人是抽象的，wqq才是具体的）
- 抽象类不能被final修饰，因为抽象方法就是被子类实现的

抽象类中可以包含方法实现，可以将一些公共的代码放到抽象类中，另外在抽象类中可以定 义一些抽象的方法，这样就会存在一个约束，而子类必须实现我们定义的方法，如：teacher 必须实现 printInfo 方法，Student 也必须实现 printInfo 方法，方法名称不能修改，必须为 printInfo，这样就能实现多态的机制，有了多态的机制，我们在运行期就可以动态的调用子 类的方法。所以在运行期可以灵活的互换实现。

```java
public class AbstractTest01{
	public static void main(String[] args){
		//抽象类不能被实例化 需要被继承
		//Person p = new Person();
		Person p = new Employee();
		p.setName("wqq");
		System.out.println(p.getName());
	}
}
abstract class Person{
	private String name;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void commonMethod1(){
		System.out.println("------commonMethod------");
	}
    //定义abstract抽象方法
    public abstract void PrintInfo(){
        
    }
}

abstract class Employee extends Person{
    //再次声明该方法是抽象的
    public abstract void PrintInfo(){}
}

class Student extends Person{
    //实现抽象方法
    public void PrintInfo(){
        System.out.println("Student.PrintInfo()");
    }
}
```



### 接口

接口可以看做是**抽象类的一种特殊情况**，在接口中只能定义抽象的方法和变量。

- 使用**interface**关键字声明接口文档
- 接口中的方法默认都是**public abstract**的，**不能更改**
- 接口中的变量是**public static final**类型的（final就导致变量必须显示的初始化），不能更改
- **接口之间可以继承**（接口支持多继承），但接口不能实现接口的方法，接口的方法只能被类实现
- 接口不能被实例化，接口没有构造函数的概念
- 接口中的方法只能通过类来实现，通过implements关键字
- 如果一个类实现了接口，那么接口中的**所有方法**都必须被**实现**
- **一类可以实现多个接口**
- 抽象类包含的抽象方法必须在其子类中被实现，否则该子类也必须是抽象类

```java
public class MammalInt implements Animal{
 
   public void eat(){
      System.out.println("Mammal eats");
   }
 
   public void travel(){
      System.out.println("Mammal travels");
   } 
 
   public int noOfLegs(){
      return 0;
   }
 
   public static void main(String args[]){
      MammalInt m = new MammalInt();
      m.eat();
      m.travel();
   }
}

interface Animal {
   public void eat();
   public void travel();
}
```



#### 接口的进一步应用

实现接口的好处

- 明确的声明了它所能提供的服务
- 解决了java单继承的问题
- 实现了**可接插性**



### 多态（多种状态）

如方法重载，就是使用相同的方法名称完成不同的功能，这就是多态的一种表现，即**静态多态**。

多态的条件是：**有继承或实现，有方法覆盖或实现，父类对象（接口）指向子类对象**



### 接口和抽象类的区别

- 接口描述了方法的特征，不给出实现，一方面解决java的单继承问题，实现了**可接插性**
- 提供了部分实现，抽象类是不能被实例化的，抽象类的存在主要是可以把公共的代码移植到抽象类中
- 面向接口编程，而不是面型具体编程
- **优先选择接口（因为接口可以多继承，而类继承抽象类后无法再继承）**



### 类之间的关系

#### 泛化关系

类与类之间的继承关系及接口与接口之间的继承关系

#### 实现关系

类对接口的实现

#### 关联关系(has a)

类与类之间的连接，一个类可以知道另一个类的属性和方法，在java中用实体变量表示

```java
public class Student{
    private classroom cla;
    //getter setter
}
public class classroom{
}
```



#### 聚合关系(has a)

是关联关系的一种，是较强的关联关系，是整体和部分的关系。关联关系的类处在同一个层次上，而聚合关系的类处在不平等的层次上

```java
public class 汽车{
    private 轮胎集合 轮胎;
    //getter setter
}
public class 轮胎{
    private 汽车 汽车;
}
```



#### 合成关系

比聚合关系强的关联关系，如：人和四肢，整体对象决定部 分对象的生命周期，部分对象每一时刻只与一个对象发生合成关系，在 java 语言中使 用实例变量体现

```java
public class 人 {
    private 四肢集合 四肢；
    //getter/setter
}
public class 四肢 {
    private 人 人;
    //getter/setter
}
```



#### 依赖关系

依赖关系是比关联关系弱的关系，在 java 语言中体现为返回值，参数，局 部变量和静态方法调用

```java
public class Test {
	public static void main(String[] args) {
		Person person = new Person();
 	}
}
class Person {
}
```



### is-a、is-like-a、has-a



### Object类

- object类是所有Java类的根基类
- 如果在类的声明中未使用extends关键字指明其基类，则默认基类为Object类

#### toString()

返回该对象的字符串表示，toString方法会返回一个“以文本方式表示”此对象的字符串，Object类的toString方法返回一个字符串



#### finalize

垃圾回收器GC，主要有以下特点：

- 当对象不再被程序使用时，垃圾回收器将会将其回收
- 垃圾回收是在后台进行的，我们无法命令垃圾回收器马上回收资源，但是我们可以告诉他尽快回收资源（**System.gc() 和 Runtime.getRuntime().gc()**）
- 垃圾回收器在回收某个对象的时候，首先会调用该对象的finalize方法
- **gc主要针对堆内存（主要有数组、对象）**

```java
public class FinalizeTest{
	public static void main(String[] args){
		Person person = new Person();
		person.id = 1000;
		person.name = "张三";

		//person置为null表示不再执行堆中的对象，GC不会马上收集，收集时间不确定
		person = null;

		//通知垃圾收集器来收集垃圾
		System.gc();
		try {
			Thread.sleep(100);
		}catch(Exception e) {}
	}
}
class Person{
	int id;
	String name;
	public void finalize() throws Throwable{
		System.out.println("Person finalize()");
	}
}
```



#### == 和 equals方法

##### 等号“==”

等号可以比较基本类型和引用类型，**等号比较的是值**，特别是比较引用类型，比较的是**引用类型的内存地址**

```java
public class EqualTest{
	public static void main(String[] args){
		int a=100;
		int b=100;

		//输出为a==b
		System.out.println((a==b)?"a==b":"a!=b");

		Person p1=new Person();
		p1.id=101;
		p1.name="wang";

		Person p2=new Person();
		p2.id=101;
		p2.name="wang";

		//输出为p1!=p2 比较的是两个对象的引用地址
		System.out.println((p1 == p2)?"p1==p2":"p1!=p2");

	}
}
class Person{
	int id;
	String name;
}
```

##### equals是比较两个对象具体的值是否相等

object的equals方法默认比较的就是地址，如果不打算调用父类的equals方法，就可以对父类的equals方法进行覆写

```java
String s3 = new String("abc");
String s4 = new String("abc");
System.out.println((s3==s4)?"s3==s4":"s3!=s4");
//输出 s3 等于 s4，所以确定 string 的 equals 比较的是具体的内容
System.out.println(s3.equals(s4)? "s3 等于 s4": "s3 不等于 s4");

Person p1 = new Person();
p1.id = 1001;
p1.name = "张三";
Person p2 = new Person();
p2.id = 1001;
p2.name="张三";
//输出：p1 不等于 p2
//因为它默认调用的是 Object 的 equals 方法
//而 Object 的 equals 方法默认比较的就是地址,Object 的 equals 方法代码如下：
// public boolean equals(Object obj) {
// return (this == obj);
// }
//如果不准备调用父类的 equals 方法，那么必须覆盖父类的 equals 方法行为
System.out.println(p1.equals(p2)? "p1 等于 p2": "p1 不等于 p2");
```

##### 如何覆写equals方法?

```java
//覆盖父类的方法
//加入我们自己的比较规则
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	//判断obj实例是否属于person子类
	//同一类型，才具有可比性
	if (obj instanceof Person) {
		//将person转为obj型
		Person p = (Person)obj;
		//如果 id 相等就认为相等
		if (this.id == p.id) {
			return true;
		}
	}
	return false;
 }
```



### 包和import

#### 包

包就是目录，项目比较大，java文件比较多的时候，应该分目录管理，在java中称为分包管理，包名通常采用小写

```java
//1.包名采用小写字母
//2.包的命名应该有规则，不能重复，一般采用公司网站逆序，如：com.qqwJava.项目名称.模块名称

//package必须放到所有语句的第一行,注释除外
package com.qqwJava.exam;

public class PackageTest{
    public static void main(String[] args) {
		System.out.println("Hello Package!!!");
	}
}
//理解：包其实就是目录，针对这个Java文件的路径在“com/qqwJava/exam/PackageTest”
```



#### import引入需要的类

```java
//!!!! package语句必须放到第一句，注释除外
package com.qqwJava.exam;
//采用import引入需要的类
import com.qqwJava.exam.model.Student;

//可以采用* 通配引入包下的所有类
//但此方法效率不高
import com.qqwJava.exam.model.*;

```



#### JDK常用开发包

- java.lang，此包 Java 语言标准包，使用此包中的内容无需 import 引入 
-  java.sql，提供了 JDBC 接口类 
- java.util，提供了常用工具类 
- java.io，提供了各种输入输出流



### 访问控制权限

![image-20231105163428476](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231105163428476.png)

如果class不适用public修饰，那么此时的class只能被该包下的类访问，其他包下无法访问



### 内部类

#### 实体内部类

- 创建实体内部类，外部类的实例必须已经被创建
- 实例内部类会持有外部类的应用
- 实例内部**不能定义static成员**，只能定义实例成员
- 内部实例类可以使用private和protected修饰

```java
public class InnerClassTest{
    private int a;
    private int b;
    InnerClassTest(int a, int b){
        this.a=a;
        this.b=b;
	}
    
    //内部实例类可以使用private和protected修饰
    private class Inner{
        int i1=0;
        int i2=0;
    }
    
    public static void main(String[] args) {
		InnerClassTest.Inner inner = new InnerClassTest(100, 200).new Inner();
		System.out.println(inner.i1);
		System.out.println(inner.i2);
	}
}
```



#### 静态内部类 static

- 静态内部类不会持有外部的类的引用，创建时可以不用创建外部类
- 静态内部类可以访问外部的静态变量，如果访问外部类的成员变量必须通过外部类的实例访问

```java
public class InnerClassTest{
    static int a=100;
    int b=10;
    
    static class Inner{
        int i1=0;
        int i2=0;
        static int i3=100;
        //可以访问外部类的静态变量
        static int i4=a;
        //不可以直接访问外部类的实例变量
        //int i5=b;
        //采用外部类的引用可以取得成员变量的值
        int i5=new InnerClassTest().b;
    }
    
    public static void main(String[] args) {
		InnerClassTest.Inner inner = new InnerClassTest.Inner();
		System.out.println(inner.i1);
		System.out.println(inner.i2);
        System.out.println(inner.i3);
        System.out.println(inner.i4);
        System.out.println(inner.i5);
	}
}
```



#### 局部内部类

局部内部类是在**方法**中定义的，只能在**当前方法中使用**。和局部变量的作用一样，局部内部类和实例内部类一致，**不包含静态成员**

```java
public class InnerClassTest{
    private int a=100;
    public void method1(final int temp){
        class Inner{
            int i1=10;
            //可以访问外部类的成员变量
            int i2=a;
            int i3=temp;
        }
        Inner inner=new Inner();
        System.out.println(inner.i1);
        System.out.println(inner.i2);
        System.out.println(inner.i3);
    }
    
    public static void main(String[] args) {
		InnerClassTest inner = new InnerClassTest();
		inner.method1(666);
	}
}
```



#### 匿名内部类

匿名内部类定义在类的局部位置，如方法、代码块中，没有明确的类名，通过实现一个接口或继承一个类而创建

可以想象一下这个场景：我们通常都需要创建一个类来实现接口，但是如果我们只需要使用到这个类的一个实例，并且不需要在别的地方使用它，那么就可以创建一个匿名内部类

```java
匿名内部类有两种实现方式：1.实现接口；2.继承一个类。
格式如下 ： 
new 接口名/类名(args...){
	//内容
};

//常用方法：创建类实现接口
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, world!");
    }
}
MyRunnable myRunnable = new MyRunnable();
Thread thread = new Thread(myRunnable);
thread.start();


//使用匿名内部类 实现了Runnable接口
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello, world!");
    }
});
thread.start();


//匿名内部类的实例
public class AnonymousTest{
    public void test(Product p){
    	System.our.println(p.getName()+p.getPrice());
	}
	public static void main(String[] args){
    	var ta=new AnonymousTest();
        
        ta.test(new Product(){
            public void getName(){
                return "wang";
            }
            public void getPrice(){
                return "324.5";
            }
        })
	}
}


```

##### 匿名内部类规则

- 匿名内部类不能是抽象类，因为系统在创建匿名内部类时，会立即创建匿名内部类的对象。因此不允许将匿名内部类定义称为抽象类。
- 匿名内部类不能定义构造器。由于匿名内部类没有类名，所以无法定义构造器，但匿名内部类可以定义初始化块，可以通过实例初始化块来完成构造器所需要完成的事情。



