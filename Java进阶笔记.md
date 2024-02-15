# Java进阶笔记

## 数组

### 数组概要

数组是一种**引用数据类型**（堆内存），在内存中的存储示意图如下：

<img src="C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231107113624819.png" alt="image-20231107113624819" style="zoom: 67%;" />

- 引用类型
- 数组元素可以是基本类型，也可以是引用类型，**同一个数组只能是同一类型**
- 数组作为对象，数组元素就作为对象的属性，还包括**成员属性length**
- 数组元素有下标，下标从0开始，到n-1



### 一维数组的声明和使用

#### 数组的声明格式

```java
数组元素类型[] 变量名称
数组元素类型 变量名称[]

eg：int[] a; Studentp[] stu; int[] a,b,c;
```



#### 数组的创建

##### 1.基本类型的数组

**new操作符**来创建数组，格式为：new 数组元素的数据类型[数据元素的个数]

```java
int[] data = new int[6];
```

**内存结构**： data是局部变量存放在栈中，在堆内存中分配空间，其中有数组的成员属性length和数组元素。

<img src="C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231107142900481.png" alt="image-20231107142900481" style="zoom:40%;" />

##### 2.引用类型的数组

```java
public class ArrayTest01 {
    public static void main(String[] args) {
        Student[] stu = new Student[2];

        /*
        //出现空指针，因为引用类型的数组采用null作为默认的初始化值
        stu[0].id=1;
        stu[0].name="wang";
        stu[1].id=2;
        stu[1].name="zhang";
        */

        //可采用如下方式进行赋值
        Student wang = new Student();
        wang.id=101;
        wang.name="wang";
        stu[0]=wang;
        Student zhang = new Student();
        zhang.id=101;
        zhang.name="zhang";
        stu[1]=zhang;
        for (int i=0; i<stu.length; i++) {
            System.out.println("id=" + stu[i].id + ", name=" + stu[i].name);
        }
    }

}
class Student{
    int id;
    String name;
}
```



使用数组的初始化语句，格式为：**数组元素的类型[] 变量名称** = {数组元素 1， 数组元素 2,......数组元素 n}  或 **数组元素的类型 变量名称[]** = {数组元素 1，数组元素 2,...... 数组元素 n}

```java
//静态初始化
int[] data = {1, 2, 3, 4, 5};

Student zhangsan = new Student();
zhangsan.id = 1001;
zhangsan.name = "张三";
Student lisi = new Student();
lisi.id = 1002;
lisi.name = "李四";
//静态初始化
Student[] stu={zhangsan,lisi};
```



### 二维数组的声明和使用

数组元素的类型是数组是就变成了多维数组，二维数组的声明格式如下：

- 数组元素的数据类型 【】【】 变量名
- 数组元素的数据类型 变量名 【】【】

#### 1、使用new关键字

```java
int[][] data = new int[2][3];
//对二维数组赋值
data[0][0] = 1;
data[0][1] = 2;
data[0][2] = 3;
data[1][0] = 4;
data[1][1] = 5;
data[1][2] = 6;
```

内存结构

![image-20231107145814857](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231107145814857.png)

#### 2、从高维开始逐维创建

```java
//从高维开始逐维创建
int[][] data = new int[2][];
data[0] = new int[2];
data[1] = new int[4];
data[0][0] = 1;
data[0][1] = 2;
data[1][0] = 1;
data[1][1] = 2;
data[1][2] = 3;
data[1][3] = 4;
```

#### 3、采用初始化语句块创建数组对象

```java
//静态初始化
int[][] data = {{1,2},{1,2,3,4}};
```



### Arrays工具类

注意要**import java.util.Arrays；**

#### Arrays.toString()

将数组转为字符串输出

```java
int[] arr = {1, 2, 3};
System.out.println(Arrays.toString(arr)); 
```



#### Arrays.sort()

给数组排序，默认升序

```java
int[] data = {3,1,6,2,5};
Arrays.sort(data);
for (int i=0; i<data.length; i++) {
	System.out.println(data[i]);
}
```

  另一种重载形式：**Arrays.sort(数组名，起始下标，排序个数)**

```java
Scanner s = Scanner(System.in);
int n = s.nextInt();
int[] a = new int[n];
for(int i = 0; i < n; i++)
   a[i] = s.nextInt();
Arrays.sort(a,0,n - 1);
```



#### Arrays.equals()

比较数组内容是否相等，如果相等则返回true，不相等则返回false

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};
boolean isEqual = Arrays.equals(arr1, arr2);
System.out.println(isEqual);
//true
```



#### Arrays.binarySearch ()

二分查找数组中的某个值

```java
int[] data = {3,1,6,2,5};
Arrays.sort(data);
int index = Arrays.binarySearch(data, 3);
```



#### Arrays.fill()

将指定的值填充数组

```java
public class experiment {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Arrays.fill(arr, 10);
        System.out.println(Arrays.toString(arr));
    }
}
//[10,10,10,10,10]
```



#### Arrays.copyOf()

复制指定数组，当中的第一个参数是复制的原数组，第二个参数是复制的长度

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = Arrays.copyOf(arr1, 5);
System.out.println(Arrays.toString(arr2));
//[1,2,3,0,0]
```

这个的返回值是一个新的数组，所以会**改变**接受这个新数组的**引用的一些属性**：

```java
int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int[] arr2 = new int[5];
arr2 = Arrays.copyOf(arr1, 10);
System.out.println("复制后，arr2的长度是："+arr2.length);
System.out.println("Arr2的内容是："+Arrays.toString(arr2));
//10
//[1,2,3,4,5,6,7,8,9,10]
```





## String类

#### String类是不可变类（类和value数组都是被final修饰的），String对象声明后将不可修改

```java
public class StringTest01 {
public static void main(String[] args) {
	String s1 = "a";
	String s2 = "b";
	s1=s1 + s2; //ab
	//new String(“a”);
	System.out.println(s1);
	}
}
```

![image-20231108161034100](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231108161034100.png)

String对象赋值后不能再修改，这就是不可变对象，如果对字符串进行修改那么会创建新的对象。

**注意**：只要采用双引号赋值字符串，那么在编译期将会放到**方法区中的字符串的常量池**里，如果是**运行**时对字符串相加或相减会放到**堆**中（放之前会先验证方法区中是否含有**相同的字符串常量**，如果存在，将地址返回，如果不存在，先将字符串常量放到池中，然后再返回该对象的地址）



#### new String() 和 静态初始化

```java
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println("s1==s2, " + (s1==s2));
        System.out.println("s2==s3, " + (s2==s3));
        System.out.println("s2 equlas s3," + (s2.equals(s3)));
    }
}
//s1==s2 true
//s2==s3 false
//s2 equals s3 true
```

- 如果采用双引号初始化的字符串常量，首先会去**常量池**中查找，如果存在就不再分配，**常量池中的数据都是在编译期间赋值的**，也就是生成class文件时就把它放到常量池中（可以使用**System.identityHashCode()**方法来打印字符串的地址）
- s3是采用new的方式创建，所以会到常量区中查找“abc”，而常量区中存在“abc”，所以常量区将不再放置字符串，而**new关键字**会在**堆中分配内存**，所以会在堆中创建一个对象abc，s3会指向abc
- 如果比较s2和s3的值必须采用equals，String已经对equals方法进行了覆盖



#### String面试题分析

```java
String s1=new String("hello");
String s2=new String("hello");
```

以上代码创建了几个对象？

![image-20231108165449429](C:\Users\HUAWEI\AppData\Roaming\Typora\typora-user-images\image-20231108165449429.png)

创建了3个对象，堆区2个，常量池1个。

由上可以分析，使用String时，**不建议使用new关键字**，因为使用new会创建两个对象。

**注意：堆区是在运行期间分配的，常量池是在编译器分配的。**



##### 为什么String类是不可变对象？StringBuffer和StringBuilder是可变对象？

**（建议回编译器看源码**）

首先，String类是被final修饰的，并且里面的value数组也是被final修饰的，这就确定了String类被初始化后就不能被修改。String内部有concat函数进行字符串的拼接，但是拼接成功的字符串会再申请一块内存进行存储，最终会返回一个new(String(""))对象。

StringBuilder和StringBuffer是可变对象，这两个类虽然被final修饰，但是其中的成员变量value数组并不是final类型，是可以修改的。

StringBuffer---线程安全，速度不快，StringBuilder---线程不安全、速度快。



#### String常用方法

```java
endsWith 判断字符串是否以指定的后缀结束	//s1.endsWith("com")--->true/false
startsWith 判断字符串是否以指定的前缀开始 //s2.endsWith("com")--->true/false
equals 字符串相等比较，不忽略大小写
equalsIgnoreCase 字符串相等比较，忽略大小写
indexOf 取得指定字符在字符串的位置
lastIndexOf 返回最后一次字符串出现的位置
length 取得字符串的长度
replaceAll 替换字符串中指定的内容
split 根据指定的表达式拆分字符串
substring 截子串 
trim 去前尾空格
valueOf 将其他类型转换成字符串   
```



#### 使用String的注意事项

1. 由于String是不可变对象，如果使用**多个字符串进行拼接**，将会形成多个对象，可能会造成内存溢出，给垃圾回收带来工作量。

```java
String s="";
for(int i=0;i<9;i++){
    //会产生大量对象
    //建议使用StringBuffer或StringBuilder
	s=s+i;
}
```

   2.定义一个String对象时一定要初始化，不然编译不会通过



#### 初级正则表达式

正则表达式，主要用来做字符串处理，可以描述特定的字符模式，如：

a{2}表示由两个字符“a"构成的字符串，等同于普通字符串”aa“;

"\d"代表任意一个数字0-9，

“\D”代表所有的非数字，

“\w”代表所有的英文字母，

“\W”代表所有的非英文字母；

```java
String s1 =
     "asdd33dfsdaf33ddsd55fdd3dssf4343sdf455ddsdddh565gggh55ddhg";
//将 dd 替换为"中"
System.out.println(s1.replaceAll("dd","中"));
System.out.println(s1.replaceAll("d{2}","中"));
//将数字替换为"中"
System.out.println(s1.replaceAll("\\d", "中"));
//将非数字替换为"中"
System.out.println(s1.replaceAll("\\D", "中"));
```



## StringBuffer和StringBuilder

#### StringBuffer

StringBuffer称为**字符缓冲区**，工作原理是：预先申请一块内存，存放字符序列，如果字符序列满了，会重新改变缓存区的大小，以容纳更多的字符序列。**StringBuffer是可变对象，而String是不可变对象**。

```java
/*apend(String s)将指定字符串追加到此字符串序列
reverse()反转字符串
delete(int start,int end) 移除此序列的子字符串中的字符
insert(int offset,int i) 将int参数的字符串表示形式插入此序列中
insert(int offset,String str)
replace(int start,int end,String str)使用String中的字符替换此序列的子字符串的字符

更多方法查看：https://www.runoob.com/java/java-stringbuffer.html
*/
StringBuffer sbStr = new StringBuffer();
for(int i=0;i<100;i++){
	sbStr.append(i).append(",");
}
//可以输出
System.out.println(sbStr);
System.out.println("");
System.out.println(sbStr.toString());dcsa
System.out.println("");
//去除逗号
       System.out.println(sbStr.toString().substring(0,sbStr.toString().length()-1));
System.out.println("");
System.out.println(sbStr.substring(0, sbStr.length()-1));
```

#### StringBuilder

用法同StringBuffer，StringBuffer和StringBuilder的区别是StringBuffer中所有的方法都是同步的，是线程安全的，但速度慢，**StringBuilder的速度快，但不是线程安全**。



## 基本类型对应的包装类

![image-20231108201759749](../../Typora_Images/image-20231108201759749.png)

为什么要有包装类？



#### JDK5.0的新特性

- 自动将**基础类型**转换为**对象**
- 自动将对象转换为基础类型

```java
public static void main(String[] args) {
	//jdk1.5 以前版本，必须按如下方式赋值
	Integer i1 = new Integer(100);
	//jdk1.5 及以后版本支持
	//自动装箱
	Integer i2 = 100;
	//jdk1.5 及以后版本支持
	//自动拆箱
	int i3 = i2;
    //jdk1.5 以前版本，必须按如下方式赋值
    int i4 = i2.intValue();
}
```



## 日期类

常用的日期类：

- java.util.Date 
- java.text.SimpleDateFormat 
- java.util.Calendar

```java
public static void main(String[] args) {
	Date today = new Date();
   	System.out.println(today);

        //格式化日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(sdf.format(today));

	Calendar c= Calendar.getInstance();
	System.out.println(c.get(Calendar.DAY_OF_MONTH));
	//取得 2000-10-01 为星期几
	Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2000-10-01");
	c.setTime(d);
	System.out.println(c.get(Calendar.DAY_OF_WEEK));
}
```





## 数字类

#### java.text.DecimalFormat 

```java
public static void main(String[] args) throws Exception{
	//加入千分位，保留两位小数
	DecimalFormat df = new DecimalFormat("###,###.##");
	System.out.println(df.format(1234.23452));
	//加入千分位保留 4 位小数，不够补零
	System.out.println(new 							DecimalFormat("###,###.0000").format(12345.12));
}
```



#### java.math.BigDecimal

BigDecimal可以精确计算，特别是财务数据

```java
BigDecimal v1 = new BigDecimal(10);
BigDecimal v2 = new BigDecimal(20);
//相加运算
BigDecimal v3 = v1.add(v2);
System.out.println(v3);
```



## Random

Random 位于 java.util 包下，可以产生随机数

```java
import java.util.Random;

public static void main(String[] args) {
	Random r=new Random();
	for (int i=0; i<5; i++) {
		System.out.println(r.nextInt(100));
	}
}
```



## Enum枚举类

#### 枚举的意义

减少类的定义、语义明确、实现了代码复用



**java.lang.Enum**

Java枚举是一个**特殊的类**，一般表示**一组常量**。使用enum关键字来定义，各个常量使用逗号分割。

```java
enum color{
    RED,GREEN,BLACK,BLUE
}

public class Test
{
    // 执行输出结果
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}
```

#### 内部类中使用枚举

枚举类也可以声明在内部类中

```java
public class Test 
{ 
    enum Color 
    { 
        RED, GREEN, BLUE; 
    } 
  
    // 执行输出结果
    public static void main(String[] args) 
    { 
        Color c1 = Color.RED; 
        System.out.println(c1); 
    } 
}
```

#### 迭代枚举元素

```java
enum Color { 
    RED, GREEN, BLUE; 
} 
public class MyClass { 
	public static void main(String[] args) { 
        for (Color myVar : Color.values()) {
            System.out.println(myVar);
    	}
  	} 
}
```

#### 在Switch中使用枚举类

```java
Color myVar = Color.BLUE;
    switch(myVar) {
      case RED:
        System.out.println("红色");
        break;
      case GREEN:
         System.out.println("绿色");
        break;
      case BLUE:
        System.out.println("蓝色");
        break;
```

#### values(), ordinal() 和 valueOf() 方法

- values()返回枚举类中所有的值
- ordinal()方法可以找到每个枚举常量的索引
- valueOf()方法返回指定字符串值的枚举常量

```java
enum Color { 
    RED, GREEN, BLUE; 
} 
  
public class Test { 
    public static void main(String[] args) { 
        // 调用 values() 
        Color[] arr = Color.values(); 
  
        // 迭代枚举
        for (Color col : arr) { 
            // 查看索引
            System.out.println(col + " at index " + col.ordinal()); 
        } 
  
        // 使用 valueOf() 返回枚举常量，不存在的会报错IllegalArgumentException 
        System.out.println(Color.valueOf("RED")); 
        // System.out.println(Color.valueOf("WHITE")); 
    } 
}

输出：
RED at index 0
GREEN at index 1
BLUE at index 2
RED
```

#### 枚举类成员

- 枚举跟普通类一样可以用自己的变量、方法和构造函数，构造函数只能使用private访问修饰符，所以外部无法调用
- 枚举既可以包含**具体方法**，也可以包含**抽象方法**。如果枚举类具有抽象方法，则枚举类的每个实例都必须实现它

```java
enum Color 
{ 
    RED, GREEN, BLUE; 
  
    // 构造函数
    private Color() 
    { 
        System.out.println("Constructor called for : " + this.toString()); 
    } 
  
    public void colorInfo() 
    { 
        System.out.println("Universal Color"); 
    } 
} 
  
public class Test 
{     
    // 输出
    public static void main(String[] args) 
    { 
        Color c1 = Color.RED; 
        System.out.println(c1); 
        c1.colorInfo(); 
    } 
}
```



## 异常

#### 异常的基本概念

异常是程序在运行过程中出现的错误



#### 异常的分类

##### 异常的层次结构

![image-20231109120042913](../../Typora_Images/image-20231109120042913.png)

##### 异常的分类

异常主要分为：错误、一般性异常（受控异常）、运行期异常（非受控异常）

- **错误**：如果应用程序出现了Error，那么将无法恢复，只能重新启动应用程序，最典型的Error异常是：OutOfMemoryError内存溢出异常、StackOverflowError深递归导致栈被耗尽而抛出的异常

- **受控异常**：出现了这种异常必须显示的处理，不显示处理java程序将无法编译通过（编译时异常）

  如何处理受控异常？---- 1.捕捉（try...catch...）2.声明抛出（throw是、）

- **非受控异常**：此种异常可以不用显示的处理，例如被0除异常，java没有要求一定要处理，不做处理也能编译通过。



##### try、catch和finally

异常的捕获和处理采用try和catch处理，具体格式如下：

```java
try{
    
}catch(OneException e){
    
}catch(TwoException e){
    
}finally{
    
}
```

- try中包含了可能产生异常的代码，try后面可以有一个或多个catch，catch中是需要捕获的异常

- 当try中的代码出现异常时，出现异常下面的代码不会执行，马上会跳转到对应的catch语句块中，如果没有异常则不会跳转到catch中

- finally表示不管是出现异常还是没有出现异常，finally里的代码都会执行，**finally和catch可以分开使用，但是finally必须和try一起使用**，如下：

  ```java
  try{
      
  }finally{
      
  }
  
  //示例代码：
  public class ExceptionTest {
      public static void main(String[] args){
          int i1=100;
          int i2=0;
          try{
              int i3=i1/i2;
              System.out.println(i3);
          }catch(ArithmeticException ae){
              System.out.println("被0除了");
          }
      }
  }
  ```



##### getMessage()和printStackTrace()

取得异常对象的具体信息，常用的方法主要有两种：

- 取得异常描述信息：getMessage（）
- 取得异常的堆栈信息（比较适合程序调试阶段）：printStackTrace()

```java
public class ExceptionTest {
    public static void main(String[] args){
        int i1=100;
        int i2=0;
        try{
            int i3=i1/i2;
            System.out.println(i3);
        }catch(ArithmeticException ae){
            System.out.println(ae.getMessage());
            ae.printStackTrace();
            System.out.println("被0除了");
        }
    }
}
```



#### 受控异常

```java
import java.io.FileInputStream;
public class ExceptionTest05 {
	public static void main(String[] args) {
		FileInputStream fis = new FileInputStream("test.txt");
	}
}

//出现了FileNotFoundException,在调用的时候找不到该文件

import java.io.*;
public class ExceptionTest06 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test.txt");
		}catch(FileNotFoundException ffe) { //此异常为受控异常，必须处理
			ffe.printStackTrace();
		}
	}
}
```



##### finally关键字

finally在任何情况下都会执行，通常在finally中关闭资源

```java
public class ExceptionTest10 {
	public static void main(String[] args) {
		int i1 = 100;
		int i2 = 10;
		try {
			int i3 = i1/i2;
			System.out.println(i3);
			//return;
			System.exit(-1); //java 虚拟机退出
		}catch(ArithmeticException ae) {
			ae.printStackTrace();
		}finally {
			//只有 java 虚拟机退出不会执行 finally
			//其他任何情况下都会执行 finally
			System.out.println("----------finally---------	");
		}
	}
}
```



#### final、finally、finalize 的区别

##### final

final是用于修饰变量、方法和类，特点如下：

- 被修饰的变量不可变，不可变可以分为引用不可变和对象不可变，而final指的是引用不可变，final修饰的变量必须初始化。具体实例：String类
- 被修饰的方法不允许任何子类重写
- 被修饰的类不能被继承，所有方法不能被重写



##### finally

finally是异常处理的一部分，它只能出现在`try/catch`语句中，并且finally附带的语句一定会被执行，经常用于释放资源，`System.exit (0)` 可以阻断 finally 执行。好处：用 finally 可以维护对象的内部状态，并可以清理非内存资源。

特别是在关闭数据库连接这方面，如果程序员把数据库连接的close()方法放到finally中，就会大大降低程序出错的几率。



##### finalize

finalize 是在 `java.lang.Object` 里定义的方法，每个对象都有这样的方法，垃圾回收器在回收某个对象的时候，首先会调用该对象的finalize方法。

一个对象的 finalize 方法只会被调用一次，finalize 被调用不一定会立即回收该对象，所以有可能调用 finalize 后，该对象又不需要被回收了，然后到了真正要被回收的时候，因为前面调用过一次，所以不会再次调用 finalize 了，进而产生问题，因此不推荐使用 finalize 方法。

不建议用`finalize()`方法完成“非内存资源”的清理工作，但建议用于：
① 清理本地对象(通过JNI创建的对象)；
② 确保某些非内存资源(如Socket、文件等)的释放：在`finalize()`方法中显式调用其他资源释放方法。



#### 声明和抛出异常

##### throws声明异常

```java
格式： public 返回值类型 方法名（） throws 异常类型1，异常类型2{};
作用： 告诉调用该方法的调用者，该方法可能会发生什么异常;
    
public void setAge(int age) throws Exception {
	if(age>120||age<0){//方法上throws声明异常
		throw new Exception("年龄不合法");//方法中throw抛出异常
	}else{
		this.age=age;
	}
}
```

##### throw抛出异常

```java
格式： throw new Exception("异常提示信息");

public void setAge(int age) throws Exception {
	if(age>120||age<0){//方法上throws声明异常
		throw new Exception("年龄不合法");//方法中throw抛出异常
	}else{
		this.age=age;
	}
}
```

**注意：throw一般都会和throws连用**



#### 异常的捕获顺序

异常的捕获顺序应该是：从小到大

```java
try{
    FileInputStream fis = new FileInputStream("test.txt");
}catch(IOException e){
	e.printStackTrace();
}catch(FileNotFoundException e){
	e.printStackTrace();
}

不能编译通过，IOException是FileNotFoundException的父类，所以截获了IOException异常后，IOException的子异常都不会执行到。
异常的捕获一般按照从小到大的顺序，先截获子异常，再截获父异常
```



#### 如何自定义异常？

自定义异常通常继承于Exception或RuntimeException，到底继承哪个要看具体情况

##### 自定义受控异常

注意：受控异常必须使用throws显示声明

```java
import java.io.*;

public class ExceptionTest19 {
	public static void main(String[] args) {
		try {
			method1(10, 0);
		}catch(MyException e) {
		//必须拦截,拦截后必须给出处理，如果不给出处理，就属于吃掉了该异常
		//系统将不给出任何提示，使程序的调试非常困难
		System.out.println(e.getMessage());
		}
	}
	private static void method1(int value1, int value2) throws MyException { //如果是受控异常必须声明
		if (value2 == 0) {
			throw new MyException("除数为 0");
		}
		int value3 = value1 / value2;
		System.out.println(value3);
		}
	}

//自定义受控异常
class MyException extends Exception {
	public MyException() {
		//调用父类的默认构造函数
		super();
	}
	public MyException(String message) {
		//手动调用父类的构造方法
		super(message);
	}
}
```

##### 自定义非受控异常

```java
public class ExceptionTest20 {
	public static void main(String[] args) {
		method1(10, 0);
	}
	private static void method1(int value1, int value2){
		if (value2 == 0) {
			//抛出非受控异常，方法可以不使用throws 进行声明
			//但也也可以显示的声明
			throw new MyException("除数为 0");
		}
		int value3 = value1 / value2;
		System.out.println(value3);
	}
}

//自定义非受控异常
class MyException extends RuntimeException {
	public MyException() {
        //调用父类的默认构造函数
        super();
	}
    
	public MyException(String message) {
    	//手动调用父类的构造方法
		super(message);
	}
}
```



### 方法的覆盖与异常

#### 方法覆盖的条件：

子类方法不能抛出比父类方法更多的异常。但可以抛出父类方法异常的子异常





## Java集合

![image-20231111145406856](../../Typora_Images/image-20231111145406856.png)

### Map部分

![image-20231111145651216](../../Typora_Images/image-20231111145651216.png)



### 主要集合概述

- **List**：有序集合，可以放重复数据
- **Set**：无序集合，不允许放重复的数据
- **Map**：无序集合，集合中包含一个**键对象**，一个值对象，**键对象不允许重复**，值对象可以重复



### Collection 和 Iterator

Collection 是 List 和 Set 的父接口，在 Collection 中定义了一些主要方法：

![img](https://img-blog.csdn.net/20180601001348225?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d6aF8xMjNfMTIz/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

Iterator接口主要用来操作java中的集合对象Collection，迭代器提供了统一的语法进行集合对象Collection遍历操作，无需关系集合对象内部的实现方式。

```
hasNext --判断是否还有下一个对象，如果有，则返回true，否则false
next --返回集合的下个值，此方法只能在hasNext方法返回true时调用
remove --删除集合的当前值，此方法也只能在hasNext方法返回true时调用
```



### List接口

list接口下面主要有两个实现ArrayList和LinkedList，都是有顺序的，基于线性存储，可以看做是一个可变数组

- **ArrayList**：查询数据比较快，添加和删除数据比较慢（基于可变数组）
- **LinkedList**：查询数据比较慢，添加和删除数据都比较快（基于链表数据结构）
- Vector：不建议使用，已经被ArrayList取代
- Stack：是继承了Vector实现了一个栈，目前已经被LinkedList取代

```java
package com.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ArrayListTest {
    public static void main(String[] args){
        List l = new ArrayList();
        //自动装箱，适合于 jdk1.5
        l.add(1);
        l.add(3);

        //调用 remove 删除集合中的元素
        //如果元素重复会 remove 掉第一个匹配的
        l.remove(2);

        //采用 Iterator 遍历数据（while 循环）
        //Iterator 是一种模式，主要可以统一数据结构的访问方式
        //这样在程序中就不用关心各个数据结构的实现了
        //使对不同数据结构的遍历更加简单了，更加统一了
        Iterator iter = l.iterator();
        while (iter.hasNext()) {
            Integer v = (Integer)iter.next();
            System.out.println(v);
        }
        System.out.println("");
        //采用 Iterator 遍历数据（for 循环）
        for (Iterator iter1=l.iterator(); iter1.hasNext();){
            Integer v = (Integer)iter1.next();
            System.out.println(v);
        }

        //在集合中是否包含 3，输出为：true
        System.out.println(l.contains(3));
        //集合是否为空，输出：false
        System.out.println(l.isEmpty());
        System.out.println("");
        //转换成对象数组
        Object[] oArray1 = l.toArray();
        for (int i=0; i<oArray1.length; i++) {
            Integer v = (Integer)oArray1[i];
            System.out.println(v);
        }
        System.out.println("");
        //运行时自动创建相应类型的数组
        Integer[] iArray = new Integer[l.size()];
        l.toArray(iArray);
        for (int i=0; i<iArray.length; i++) {
            int v = iArray[i];
            System.out.println(v);
        }
    }
}
```



### LinkedList

用法同ArrayList



### Set接口

#### 哈希表

哈希表是一种数据结构，能够快速存取操作。哈希表是基于**数组**的，所以也存在缺点，数组一旦创建将不能扩展。

#### HashSet

HashSet中的数据是无序的不可重复的。HashSet按照哈希算法存取数据，具有非常好的性能，当向HashSet中插入数据时，会调用对象的hashCode得到该对象的哈希码，然后根据哈希码计算出该对象插入到集合中的位置。

```java
import java.util.*;

public class HashSetTest {
    public static void main(String[] args){
        Set set=new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        //输出是无序的
        for (Iterator iter=set.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
        //加入重复数据
        set.add("a");
        System.out.println("");
        for (Iterator iter=set.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 equals s2 ," + s1.equals(s2));
        //equals 相等，hashcode 一定是相等的
        System.out.println("s1.hashCode=" + s1.hashCode());
        System.out.println("s2.hashCode=" + s2.hashCode());
        String s3 = "ddddd";
        System.out.println("s1 equlas s3," + s1.equals(s3));
        System.out.println("s3.hashCode=" + s3.hashCode());
    }
}
```



#### TreeSet

Treeset可以对Set集合进行排序，默认自然排序（即升序），也可以做个性化的排序。



#### 实现Comparable接口完成排序

```java
class Person implements Comparable{
    String name;
    int age;

    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            //升序
            //return (this.age - p.age);
            //降序
            return (p.age - this.age);
        }
        throw new IllegalArgumentException("非法参数，o=" + o);
    }
}
```



#### 实现Comparator接口完成排序

```java
public class ComparatorTest{
    public static void main(String[] args){
        Person p1 = new Person();
		p1.name = "张三";
		p1.age = 20;
        Person p3 = new Person();
        p3.name = "张三";
        p3.age = 40;
        Person p2 = new Person();
        p2.name = "李四";
        p2.age = 30;
		Comparator personComparator = new PersonComparator();
        Set set = new TreeSet(personComparator);
        set.add(p1);
        set.add(p2);
		set.add(p3);
        
        for(Iterator iter=set.iterator();iter.hasNext();){
			Person p =(Person)iter.next();
            System.out.println("name=" + p.name + ", age=" + p.age);
        }
    }
}

class Person{
    String name;
    int age;
}

class PersonComparator implements Comparator{
    public int compare(Object o1, Object o2) {
		if (!(o1 instanceof Person)) {
			throw new IllegalArgumentException("非法参数，o1=" + o1);
		}
		if (!(o2 instanceof Person)) {
			throw new IllegalArgumentException("非法参数，o2=" + o2);
		}
        Person p1 = (Person)o1;
		Person p2 = (Person)o2;
		return p1.age - p2.age;
    }
}
```



#### 采用匿名类完成 Comparator 的实现

```java
Set set = new TreeSet(new Comparator(){
    public int compare(Object o1,Object o2){
		if (!(o1 instanceof Person)) {
        	throw new IllegalArgumentException("非法参数，o1=" + o1);
        }
        if (!(o2 instanceof Person)) {
        	throw new IllegalArgumentException("非法参数，o2=" + o2);
        }
        Person p1 = (Person)o1;
        Person p2 = (Person)o2;
        return p1.age - p2.age;
    }
});
```



#### Comparable和Comparator的区别

##### 从字面看

Comparable是”比较“的意思，表示它自身具备着某种能力，Comparator是”比较器“的意思，表示自身是比较的参与者

##### Comparable

comparable是排序接口，定义简单，源码如下：

```java
public interface Comparable<T> {
    int compareTo(T t);
}
```

##### Comparator

接口定义较为复杂

```java
public interface Comparator<T> {
    int compare(T o1, T o2);
    boolean equals(Object obj);
}
```

- 一个类实现了 Comparable 接口，意味着该类的对象可以直接进行比较（排序），但比较（排序）的方式只有一种，很单一。
- 一个类如果想要保持原样，又需要进行不同方式的比较（排序），就可以定制比较器（实现 Comparator 接口）。
- Comparable 接口在 `java.lang` 包下，而 `Comparator` 接口在 `java.util` 包下，算不上是亲兄弟，但可以称得上是表（堂）兄弟。



### Map接口

Map实现较为常用的是HashMap，HashMap对键对象的存取和HashSet一样，仍然采用的是哈希算法，所以如果使用自定类作为Map的键对象，必须覆写equals和hashcode方法。

#### HashMap

HashMap是基于哈希表+数组来实现的



#### TreeMap

TreeMap是基于红黑树实现的





### Collections 工具类

Collections位于java.util包中，提供了一系列使用的方法，如对集合排序、查找集合内容。

```java
List l = new ArrayList();
l.add(5);
l.add(1);
l.add(4);
l.add(2);
for (Iterator iter=l.iterator(); iter.hasNext();) {
	System.out.println(iter.next());
}
System.out.println("");
Collections.sort(l);
for (Iterator iter=l.iterator(); iter.hasNext();) {
	System.out.println(iter.next());
}
```



## 泛型初步

### 为什么会引入泛型

泛型提供了编译时类型安全检测机制，该机制允许程序员在**编译时**检测到非法的类型。

泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。

```java
//使用泛型 List源码就是List<E>
public class Main {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);

        for(Iterator<Integer> iter=l.iterator();iter.hasNext();){
            Integer s=iter.next();
            System.out.println(s);
        }
    }
}
```

自定义泛型

`public class GenericTest<T>;`

`private T obj;`



## 遗留类

![image-20231114164622309](../../Typora_Images/image-20231114164622309.png)



## IO流

### IO流的分类

- 按照**流的方向**分类（**输入流、输出流**），往内存中去---输入，往内存中出来---输出
- 按照**读取数据方式**
  - 按照字节的方式读取数据。一次读取1个字节，万能流（什么都能读），包括文本文件、图片、声音文件、视频文件等
  - 按照字符的方式读取数据。一次读取1个字符，为了方便读取普通文本文件，这种流不能读取：图片、声音、视频等文件。只能读取文本文件（.txt），连word文件都无法读取
  - eg：“a中国b”，如果按照字节流的方式读取：1.读取‘a’；2.读取“中”的一半；3.读取“中”的另一半；4.读取‘b’；如果按照字符读取：1.读取‘a’；2.读取“中”

### java.io 包

IO流这块主要分为四大类

	java.io.InputStream  字节输入流
	java.io.OutputStream 字节输出流	
	java.io.Reader		字符输入流
	java.io.Writer		字符输出流
	都是abstract class
	所有的流都实现了：
				java.io.Closeable接口，都是可关闭的，都有close()方法。
				流毕竟是一个管道，这个是内存和硬盘之间的通道，用完之后一定要关闭，
				不然会耗费(占用)很多资源。养成好习惯，用完流一定要关闭。
	
	所有的输出流都实现了：
				java.io.Flushable接口，都是可刷新的，都有flush()方法。
				养成一个好习惯，输出流在最终输出之后，一定要记得flush()
				刷新一下。这个刷新表示将通道/管道当中剩余未输出的数据
				强行输出完（清空管道！）刷新的作用就是清空管道。
				注意：如果没有flush()可能会导致丢失数据。


在java中只要类名以“Stream”结尾的都是字节流，以“Reader/Writer”结尾的都是字符流。java.io包下需要掌握的流有16个：

- 文件专属

  - ```java
    java.io.FileInputStream（掌握）
    java.io.FileOutputStream（掌握）
    java.io.FileReader
    java.io.FileWriter
    ```

- 转换流（将字节流转换为字符流）

  - ```java
    java.io.InputStreamReader
    java.io.OutputStreamWriter
    ```

- 缓冲流专属

  - ```java
    java.io.BufferedReader
    java.io.BufferedWriter
    java.io.BufferedInputStream
    java.io.BufferedOutputStream
    ```

- 数据流专属

  - ```
    java.io.DataInputStream
    java.io.DataOutputStream
    ```

- 标准输出流

  - ```
    java.io.PrintWriter
    java.io.PrintStream（掌握）
    ```

- 对象专属流

  - ```
    java.io.ObjectInputStream（掌握）
    java.io.ObjectOutputStream（掌握）
    ```

### InputStream 字节输入流

InputStream是一个抽象类，所有继承了该类的都是字节输入流。

![image-20231201221419558](../../Typora_Images/image-20231201221419558.png)

主要方法 `void close()` `abstract int read()`  `int read(byte[] b)` `int read(byte[] b,int off,int len)`





## 多线程

### 基本概念

线程指进程中的一个执行场景，也就是执行流程。

- 每个进程是一个应用程序，都有独立的内存空间
- 同一个进程中的线程**共享**进程的内存和资源，**共享内存时堆内存和方法去内存，栈内存不用，每个线程有自己的**。（栈内存是存放局部变量表）

引入**多进程**的原因：**提高CPU的使用率**

**注意**：进程和进程之间的内存独立



### 进程实例分析

对于java程序来说，在DOS命令窗口中输入：`java helloword` 命令后，会先启动JVM，而JVM是一个进程。JVM会再启动一个主线程来调用main方法，同时再启动一个垃圾回收线程负责看护、回收垃圾。最起码现在的java程序中会有两个线程并发，一个是垃圾回收线程，一个是执行main方法的主线程。



### 进程引入多线程的作用？

提高进程的使用率，线程和线程之间**栈内存独立**，堆内存和方法区内存共享。一个线程一个栈。



### Java程序的执行原理

Java命令执行会启动JVM，JVM的启动表示启动一个应用程序，表示**启动了一个进程**。该进程会自动启动一个“主线程”，主线程负责调用某个类的main方法，所以main方法的执行是在主线程中执行的。main方法还可以启动其他的“分支线程”，main方法结束程序不一定结束，可能还有其他的分支线程还在执行。



### 线程的创建和启动

Java虚拟机的主线程入口是main方法，用户可以自己创建线程，创建方式有两种：

- 继承Thread类
- **实现Runnable接口**（更推荐使用这种方式）
- 实现**Callable接口**



#### 继承Thread类

Thread类创建线程最重要的两个方法：`public void run() `  `public void start()`

- start()方法是启动一个分支线程，在JVM中开辟一个新的栈空间，只要新的栈空间开辟出来，start()方法就结束了
- 启动成功的线程会自动调用run()方法，并且run方法在分支栈的栈底部
- run方法在分支栈的栈底部，main方法在主栈的栈底部。run和main是平级的



#### 同步编程模型

下列代码会在run方法执行完成之后才会执行method1方法

```java
public class ThreadTest01 {
    public static void main(String[] args) {
		Processor p = new Processor();
		p.run();
		method1();
	}
	
    private static void method1() {
		System.out.println("--------method1()----------");
	}
}

class Processor {
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
	}
}

/*
输出：
0
1
2
3..10
--------method1()----------
*/
```



#### 异步编程模型

method方法没有等待前面的操作完成后才执行

```java
public class Main {
    public static void main(String[] args) {
        Processor p = new Processor();
        p.start();
        method1();
    }
    private static void method1() {
        System.out.println("--------method1()----------");
    }
}

class Processor extends Thread{
    //覆盖Thread中的run方法，该方法没有异常
    //不应该手动调用该方法
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
/*
输出：
--------method1()----------
0
1
2
3
...10
*/
```



#### 实现Runnable接口

其实 Thread 对象本身就实现了 Runnable 接口，但一般建议直接使用 Runnable 接口来写多线程 程序，因为接口会比类带来更多的好处

```Java
public class ThreadTest03 {
	public static void main(String[] args) {
	//Processor r1 = new Processor();
		Runnable r1 = new Processor();
		//不能直接调用 run
		//p.run();
		Thread t1 = new Thread(r1);
    	//启动线程
		t1.start();
		method1();
	}
	private static void method1() {
		System.out.println("--------method1()----------");
	}
}

//实现 Runnable 接口
class Processor implements Runnable {
	//实现 Runnable 中的 run 方法
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
	}
}
```



#### 实现Callable接口（JDK8新特性）

这种实现方法可以获取线程的返回值，继承Thread和实现Runable接口无法获取线程返回值，因为run方法返回值是void。

主要步骤：

1. 创建一个“未来任务类”对象（需要给Callable接口实现类对象）
2. 覆写call 方法（call方法就相当于run方法）
3. 注意：为了得到该线程的返回值，主线程会被阻塞，必须等待这个Callable接口实现的线程结束才结束主线程

```java
public class ThreadTest15 {
    public static void main(String[] args) throws Exception {

        // 第一步：创建一个“未来任务类”对象。
        // 参数非常重要，需要给一个Callable接口实现类对象。
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception { // call()方法就相当于run方法。只不过这个有返回值
                // 线程执行一个任务，执行之后可能会有一个执行结果
                System.out.println("call method begin");
                Thread.sleep(1000 * 10);
                System.out.println("call method end!");
                int a = 100;
                int b = 200;
                return a + b; //自动装箱(300结果变成Integer)
            }
        });

        // 创建线程对象
        Thread t = new Thread(task);
        // 启动线程
        t.start();

        // get()方法的执行会导致“当前线程阻塞”
        Object obj = task.get();
        System.out.println("线程执行结果:" + obj);

        // main方法这里的程序要想执行必须等待get()方法的结束
        System.out.println("hello world!");
    }
}
```





### 线程的生命周期

线程的生命周期存在五个状态：新建、就绪、运行、阻塞、死亡

![image-20231115125457454](../../Typora_Images/image-20231115125457454.png)

新建：new语句

就绪：执行start后

运行：占用CPU时间

阻塞：执行了**wait语句**、执行了**sleep语句**和等待某个对象锁，等待输入的场合

终止：退出run()方法



### 线程的调度与控制

单CPU的机器上线程不是并行运行的，多CPU上线程可以并行运行。

Java虚拟机要负责线程的调度，取得CPU的使用权，目前主要有两种调度模型：分时调度模型和抢占式调度模型，Java使用**抢占式调度模型**

**分时调度模型**：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间片

**抢占式调度模型**：优先级高的线程获取 CPU 的时间片相对多一些，如果线程的优先级相同， 那么会随机选择一个



#### 线程优先级

线 程 优 先 级 主 要 分 三 种 ： `MAX_PRIORITY( 最高级 );    MIN_PRIORITY （最低级）    NOM_PRIORITY(标准)默认`、

#### 有哪些方法可以参与线程调度呢？

- 实例方法：

  -  `void setPriority(int newPriority)`设置线程优先级
  - `int getPriority()` 获取线程优先级
  - 最低优先级1     默认优先级5     最高优先级10    （优先级比较高的线程获取CPU时间片可能会多一点，注意这里的用词是可能）

- 静态方法：

  - `static void yeild()` 让位方法
  - `yield()`方法不是阻塞方法，让当前线程让位，让给其他线程使用，会让当前线程从“运行状态”回到“就绪状态”

- 实例方法：

  - `void join()  //合并线程`

    ```java
    class MyThread1 extends Thread {
    	public void doSome(){
    		MyThread2 t = new MyThread2();
    		t.join(); // 当前线程进入阻塞，t线程执行，直到t线程结束。当前线程才可以继续。
    	}
    }
    class MyThread2 extends Thread{
    }
    ```

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Runnable r1=new Processor();
        Thread t1=new Thread(r1,"t1");
        //设置线程的优先级，线程启动后不能再次设置优先级
        //必须在启动前设置优先级
        //设置最高优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        //启动线程
        t1.start();

        //取得线程名称
        //System.out.println(t1.getName());
        Thread t2 = new Thread(r1, "t2");
        //设置最低优先级
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class Processor implements Runnable {
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }
}
```



##### Thread.sleep

- sleep方法是一个**静态方法**，`public static native`修饰的，eg：`Thread.sleep(10000)`
- 参数是毫秒
- 作用：让当前线程进入“阻塞状态”，放弃当前占有CPU时间片，让给其他线程。
- sleep方法出现在A线程中，A线程就会进入休眠，而不跟他调用的对象有关，因为该方法是一个静态方法

```java
public static void main(String[] args) {
	// 创建线程对象
        Thread t = new MyThread3();
        t.setName("t");
        t.start();

        // 调用sleep方法
        try {
            // 问题：这行代码会让线程t进入休眠状态吗？
            t.sleep(1000 * 5); // 在执行的时候还是会转换成：Thread.sleep(1000 * 5);
                                     // 这行代码的作用是：让当前线程进入休眠，也就是说main线程进入休眠。
                                     // 这样代码出现在main方法中，main线程睡眠。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5秒之后这里才会执行。
        System.out.println("hello World!");
}
```



```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Runnable r1 = new Processor();
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        Thread t2 = new Thread(r1, "t2");
        t2.start();
    }
}

class Processor implements Runnable {
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+","+i);
            if (i % 10 == 0) {
                try {
                    //睡眠 100 毫秒，主要是放弃 CPU 的使用，将 CPU 时间片交给其他线程使用
                    Thread.sleep(100);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
```



##### Thread.yield

它与 sleep()类似，只是**不能由用户指定暂停多长时间**，并且 yield()方法只能让**同优先级**的线程 有执行的机会

```java
public class Main {
    public static void main(String[] args) {
        Runnable r1 = new Processor();
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        Thread t2 = new Thread(r1, "t2");
        t2.start();
    }
}

class Processor implements Runnable {
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+","+i);
            if (i % 10 == 0) {
                System.out.println("--------------");
                //采用 yieid 可以将 CPU 的使用权让给同一个优先级的线程
                Thread.yield();
            }
        }
    }
}
```



##### t.join

当前线程可以调用另一个线程的join方法，调用后当前的线程会被阻塞不再执行，直到被调用的线程执行完毕，当前线程才会执行

通常用于主线程内 ，等到其他线程结束再结束main()主线程

```java
public class ThreadTest07 {
public static void main(String[] args) {
    Runnable r1 = new Processor();
    Thread t1 = new Thread(r1, "t1");
    t1.start();
    try {
        t1.join();
    }catch(InterruptedException e) {
        e.printStackTrace();
    }
        System.out.println("------main end-------");
    }
}
class Processor implements Runnable {
    public void run() {
        for (int i=0; i<10; i++) {
        	System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }
}
```



##### interrupt（中断）

如果我们的线程正在睡眠，可以采用 interrupt 进行中断，java并不会在真正意义上打断一个正在运行的线程，只是在形式上中断一个线程。

```java
public class ThreadTest08 {
    public static void main(String[] args) {
        Runnable r1 = new Processor();
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        try {
            //设置为 500 毫秒，没有出现中断异常，因为
            //500 毫秒之后再次调用 t1.interrupt()时，
            //此时的睡眠线程已经执行完成
            //如果 sleep 的时间设置的小一些，会出现中断异常，
            //因为存在睡眠线程
            Thread.sleep(500);
        }catch(Exception e) {
            e.printStackTrace();
        }
        //中断睡眠中的线程
        t1.interrupt();
    }
}

class Processor implements Runnable {
    public void run() {
        for (int i=1; i<100; i++) {
            System.out.println(Thread.currentThread().getName() + "," + i);
            if (i % 50 == 0) {
                try {
                    Thread.sleep(200);
                }catch(Exception e) {
                    System.out.println("-------中断-------");
                    break;
                }
            }
        }
    }
}
```



#### 如何正确的停止一个线程？

通常定义一个标记，来判断标记的状态停止线程的执行

```java
public class Main {
    public static void main(String[] args) {
        Processor r1 = new Processor();
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        try{
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }
        //停止线程
        r1.setFlag(true);
    }
}

class Processor implements Runnable {
    //线程停止标记，true 为停止
    private boolean flag;
    public void run() {
        for (int i=1; i<100; i++) {
            System.out.println(Thread.currentThread().getName() + "," + i);
//为 true 停止线程执行
            if (flag) {
                break;
            }
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
```



### 线程安全问题

#### 什么情况下会有线程安全问题？

- 多线程并发
- 有共享数据
- 共享数据有修改行为

#### 如何解决？

- 线程同步机制（“排队”，这也会牺牲一些效率）



### 线程的同步                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

（可以联想到408的os中的异步和同步的概念，同步是因为对一些共享资源的使用，导致各个线程之间相互制约，需要“排队使用”）

- 异步编程：各个线程独立执行，其实就是多线程并发
- 同步编程：各个线程需要排队等待资源



#### 从java的内存分布看线程同步

- 实例变量---堆
- 静态变量---方法区
- 局部变量---栈

**分析**

1. 局部变量存在于栈中，由于一个线程一个栈，所以局部变量不共享，也不会产生线程安全问题
2. 堆和方法区都只有1个，都是多线程共享的，所以实例变量和静态变量会存在线程安全问题
3. 局部变量+常量：不会产生线程安全问题；成员变量：可能会有线程安全问题；
4. 局部变量建议使用StringBuilder，因为局部变量不存在线程安全问题，StringBuilder效率高。

| 线程安全                | 线程不安全                                 |
| ----------------------- | ------------------------------------------ |
| Hashtable、StringBuffer | StringBuilder、ArrayList、HashMap、HashSet |



#### synchronized用法

```java
//1.同步代码块
synchronized(线程共享对象){
	同步代码块;
}

//下面是一个实例
synchronized (this) { 
    for (int i=0; i<10; i++) {
        s+=i;
    }
    System.out.println(Thread.currentThread().getName() + ", s=" + s);
    s = 0;
}

//2.在实例方法上使用synchronized，表示共享对象一定是this，并且同步代码块是整个方法体

//3.在静态方法上使用synchronized，表示找类锁，类锁永远只有1把，就算创建了100个对象，类锁也只有一把
```



#### 如何解决线程安全问题

不建议一上来就使用synchronized，因为synchronized会让程序的执行效率降低。

1. 尽量使用**局部变量**代替“成员变量和静态变量”
2. 如果必须是实例变量，可以考虑创建多个对象，不共享实例对象内存（1个线程对应1个对象，100个线程对应100个对象）
3. 如果不能使用局部变量，且实例对象不能创建多个，再考虑synchronized线程同步机制



#### 生产者消费者模式

- wait() 和 notify()不是线程对象的方法，是java中任何一个java对象的都有的方法，这两个方法都是object类自带的
- **wait()** 
  - `Object o = new Object(); o.wait();`表示让正在o对象上活动的线程进入等待状态，无限期等待，直到被唤醒
- **notify()**
  - `Object o = new Object();  o.notify();` 表示唤醒正在o对象上等待的线程
- **notify()**
  - 唤醒o对象上出于等待的所有线程

注意：这两个方法都是基于synchronized线程同步基础上的

```java
public class ThreadTest16 {
    public static void main(String[] args) {
        // 创建1个仓库对象，共享的。
        List list = new ArrayList();
        // 创建两个线程对象
        // 生产者线程
        Thread t1 = new Thread(new Producer(list));
        // 消费者线程
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}

// 生产线程
class Producer implements Runnable {
    // 仓库
    private List list;

    public Producer(List list) {
        this.list = list;
    }
    @Override
    public void run() {
        // 一直生产（使用死循环来模拟一直生产）
        while(true){
            // 给仓库对象list加锁。
            synchronized (list){
                if(list.size() > 0){ // 大于0，说明仓库中已经有1个元素了。
                    try {
                        // 当前线程进入等待状态，并且释放Producer之前占有的list集合的锁。
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序能够执行到这里说明仓库是空的，可以生产
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                // 唤醒消费者进行消费
                list.notifyAll();
            }
        }
    }
}

// 消费线程
class Consumer implements Runnable {
    // 仓库
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直消费
        while(true){
            synchronized (list) {
                if(list.size() == 0){
                    try {
                        // 仓库已经空了。
                        // 消费者线程等待，释放掉list集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序能够执行到此处说明仓库中有数据，进行消费。
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                // 唤醒生产者生产。
                list.notifyAll();
            }
        }
    }
}
```





### 守护线程

- 用户线程：主线程的main方法就是一个用户线程
- 守护线程：所有的用户线程结束生命周期后，守护线程才会结束生命周期，只要有一个用户线程存在，守护线程就不会结束。如**java中的垃圾回收器**

#### 用户线程

```java
public class UserThreadTest {
    public static void main(String[] args) {
        Runnable r1 = new Processor();
        Thread t1 = new Thread(r1, "t1");
        t1.start();
        for (int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
        System.out.println("主线程结束！！！");
    }
}

class Processor implements Runnable {
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
    }
}

/*
main, 0
main, 1
t1, 0
main, 2
t1, 1
main, 3
t1, 2
t1, 3
main, 4
t1, 4
main, 5
main, 6
t1, 5
main, 7
t1, 6
main, 8
main, 9
主线程结束！！！
t1, 7
t1, 8
t1, 9
*/
```

##### 修改为守护线程（服务线程）

```java
public class UserThreadTest {
    public static void main(String[] args) {
        Runnable r1 = new Processor();
        Thread t1 = new Thread(r1, "t1");
        //将当前线程修改为守护线程
        //在线程没有启动时可以修改以下参数
        t1.setDaemon(true);
        t1.start();
        for (int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
        System.out.println("主线程结束！！！");
    }
}

class Processor implements Runnable {
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
    }
}
```

设置为守护线程后，当主线程结束后，守护线程并没有把所有的数据输出完就结束了，也即是 说守护线程是为用户线程服务的，当**用户线程全部结束，守护线程会自动结束**（你死了，我也没有必要活）



### Timer定时器

Timer对象在内部使用多线程的方式进行处理。

##### 在指定时间执行任务

`schedule (TimerTask task , Date time)`

##### 指定时间启动任务，执行后间隔指定时间重复执行任务

`schedule (TimerTask task, Date firstTime , long period)`

##### 启动任务后，延迟多长时间执行

`schedule (TimerTask task, long delay)`

##### 启动任务后，延迟多久时间执行,执行之后指定间隔多久重复执行任务

`schedule (TimerTask task,long delay ,long period)`

```java
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) throws ParseException {
        //方法一：设定指定任务task在指定时间time执行 schedule(TimerTask task, Date time)
        //testTimer1();
        //testTimer2();
        testTimer3();
        //testTimer4();
    }
    public static void testTimer1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------任务执行--------");
            }
        }, 3500);
        // 设定指定的时间time为3500毫秒
    }

    /**
     * 方法二：设定指定任务task在指定延迟delay后间隔指定时间peroid执行
     * schedule(TimerTask task, long delay, long period)
     * */
    public static void testTimer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------任务执行--------");
            }
        }, 2000, 3500);
    }

    /**
     * 方法三：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
     * scheduleAtFixedRate(TimerTask task, long delay, long period)
     * */

    public static void testTimer3() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------任务执行--------");
            }
        }, 1000, 2000);
    }

    /**
     * 方法四：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
     * Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
     * */
    public static void testTimer4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制小时
        calendar.set(Calendar.MINUTE, 0);    // 控制分钟
        calendar.set(Calendar.SECOND, 0);    // 控制秒

        Date time = calendar.getTime();    //获取当前系统时间

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------任务执行--------");
            }
        }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
    }
}
```







## 聊一聊类加载器

### 什么是类加载器？

专门负责加载类的命令/工具。ClassLoader

### 类加载器的种类

- 启动类加载器:rt.jar
- 扩展类加载器:ext/*.jar
- 应用类加载器:classpath

### 类加载器流程

假设有这样一段代码：`String s = "abc";`

代码在开始执行之前，会将所需要类全部加载到JVM当中。通过类加载器加载，看到以上代码类加载器会找String.class文件，找到就加载，那么是怎么进行加载的呢？

1. **启动类加载器**加载。注意：启动类加载器专门加载：C:\ProgramFiles\Java\jdk1.8.0_101\jre\lib\rt.jarrt.jar中都是JDK最核心的类库。
2. 如果通过“启动类加载器”加载不到的时候，会通过"**扩展类加载器**"加载。注意：扩展类加载器专门加载：C:\ProgramFiles\Java\jdk1.8.0_101\jre\lib\ext\*.jar
3. 如果“扩展类加载器”没有加载到，那么会通过“应用类加载器”加载。注意：应用类加载器专门加载：classpath中的类。

### 类加载器的安全机制	

java中为了保证类加载的安全，使用了双亲委派机制。优先从启动类加载器中加载，这个称为“父”。“父”无法加载到，再从扩展类加载器中加载，这个称为“母”。双亲委派。如果都加载不到，才会考虑从应用类加载器中加载。直到加载到为止。



## 反射的基本概念

反射就是把java类中的各个成分映射成为一个个的java对象。它使您能够创建灵活的代码，这些代码可以在 运行时装配，无需在组件之间进行源代码链接。反射允许我们在编写与执行时，使我们的程序 代码能够接入装载到 JVM 中的类的内部信息，而不是源代码中选定的类协作的代码。注意：如果使用不当，反射的成本会很高。可以操作字节码文件。

一个类有：成员变量、方法、构造方法、包等信息，可以利用反射技术对一个类进行解刨，将一个个**组成部分**映射成为一个个**对象**。

### 为什么要有反射？

- 反射让开发人员可以通过外部类的全路径名创建对象，并使用这些类实现一些扩展的功能
- 反射可以让开发人员可以枚举出类的全部成员，包括构造方法、属性、一般方法等
- 测试时可以利用反射 API **访问类的私有成员**，以保证测试代码覆盖率



### 如何操作类的字节码

#### 获取到该类的字节码 java.lang.Class

- Class c = Class.forName("完整类名带包名");
- Class c = 对象.getClass();
- Class c = 任何类型.class;

```java
    public static void main(String[] args) {
        /*
        Class.forName()
            1、静态方法
            2、方法的参数是一个字符串。
            3、字符串需要的是一个完整类名。
            4、完整类名必须带有包名。java.lang包也不能省略。
         */
        Class c1 = null;
        Class c2 = null;
        try {
            c1 = Class.forName("java.lang.String"); // c1代表String.class文件，或者说c1代表String类型。
            c2 = Class.forName("java.util.Date"); // c2代表Date类型
            Class c3 = Class.forName("java.lang.Integer"); // c3代表Integer类型
            Class c4 = Class.forName("java.lang.System"); // c4代表System类型
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // java中任何一个对象都有一个方法：getClass()
        String s = "abc";
        Class x = s.getClass(); // x代表String.class字节码文件，x代表String类型。
        System.out.println(c1 == x); // true（==判断的是对象的内存地址。）

        Date time = new Date();
        Class y = time.getClass();
        System.out.println(c2 == y); // true (c2和y两个变量中保存的内存地址都是一样的，都指向方法区中的字节码文件。)

        // 第三种方式，java语言中任何一种类型，包括基本数据类型，它都有.class属性。
        Class z = String.class; // z代表String类型
        Class k = Date.class; // k代表Date类型
        Class f = int.class; // f代表int类型
        Class e = double.class; // e代表double类型

        System.out.println(x == z); // true

    }
```



#### 获取到Class能干什么

可以通过Class的`newInstance()`方法来实例化对象

**注意：**`newInstance()`方法内部调用了无参构造方法，必须保证有无参数的构造函数才可以

```java
public class ReflectTest02 {
    public static void main(String[] args) {

        // 这是不使用反射机制，创建对象
        User user = new User();
        System.out.println(user);

        // 下面这段代码是以反射机制的方式创建对象。
        try {
            // 通过反射机制，获取Class，通过Class来实例化对象
            Class c = Class.forName("com.bjpowernode.java.bean.User"); // c代表User类型。

            // newInstance() 这个方法会调用User这个类的无参数构造方法，完成对象的创建。
            // 重点是：newInstance()调用的是无参构造，必须保证无参构造是存在的！
            Object obj = c.newInstance();

            System.out.println(obj); // com.bjpowernode.java.bean.User@10f87f48
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
```



#### 反射机制的灵活性！！！

```java
/*
在不改变java源代码的基础上，可以做到不同对象的实例化。符合OCP开闭原则：对扩展开放，对修改关闭。

下面示例中可以通过修改配置文件classinfo.properties来实例化不同的对象
*/
public class ReflectTest03 {
    public static void main(String[] args) throws Exception{

        // 这种方式代码就写死了。只能创建一个User类型的对象
        //User user = new User();

        // 以下代码是灵活的，代码不需要改动，可以修改配置文件，配置文件修改之后，可以创建出不同的实例对象。
        // 通过IO流读取classinfo.properties文件
        FileReader reader = new FileReader("classinfo.properties");
        // 创建属性类对象Map
        Properties pro = new Properties(); // key value都是String
        // 加载
        pro.load(reader);
        // 关闭流
        reader.close();

        // 通过key获取value
        String className = pro.getProperty("className");
        System.out.println(className);

        // 通过反射机制实例化对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
```



#### Class.forName()会导致类加载

如果只是希望一个类的静态代码块执行，可以使用`Class.forName("完整类名")`，这个方法会导致类加载，而静态代码就是在类加载期间执行的。

```java
public class ReflectTest04 {
    public static void main(String[] args) {
        try {
            // Class.forName()这个方法的执行会导致：类加载。
            Class.forName("com.bjpowernode.java.reflect.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
public class MyClass {

    // 静态代码块在类加载时执行，并且只执行一次。
    static {
        System.out.println("MyClass类的静态代码块执行了！");
    }
}
```



#### 获取一个文件的绝对路径

```java

/*
研究一下文件路径的问题。
怎么获取一个文件的绝对路径。以下讲解的这种方式是通用的。但前提是：文件需要在类路径下。才能用这种方式。
 */
public class AboutPath {
    public static void main(String[] args) throws Exception{
        // 这种方式的路径缺点是：移植性差，在IDEA中默认的当前路径是project的根。
        // 这个代码假设离开了IDEA，换到了其它位置，可能当前路径就不是project的根了，这时这个路径就无效了。
        //FileReader reader = new FileReader("chapter25/classinfo2.properties");

        // 接下来说一种比较通用的一种路径。即使代码换位置了，这样编写仍然是通用的。
        // 注意：使用以下通用方式的前提是：这个文件必须在类路径下。
        // 什么类路径下？凡是在src下的都是类路径下。【记住它】
        // src是类的根路径。
        /*
        解释：
            Thread.currentThread() 当前线程对象
            getContextClassLoader() 是线程对象的方法，可以获取到当前线程的类加载器对象。
            getResource() 【获取资源】这是类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源。
         */
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("classinfo2.properties").getPath(); // 这种方式获取文件绝对路径是通用的。

        // 采用以上的代码可以拿到一个文件的绝对路径。
        // /C:/Users/Administrator/IdeaProjects/javase/out/production/chapter25/classinfo2.properties
        System.out.println(path);

        // 获取db.properties文件的绝对路径（从类的根路径下作为起点开始）
        String path2 = Thread.currentThread().getContextClassLoader()
                .getResource("com/bjpowernode/java/bean/db.properties").getPath();
        System.out.println(path2);

    }
}
```



### 操作对象属性

- `getFields()`获取public修饰的Field
- `getDeclaredFields()` 获取所有的Field

```java
/*
反射Student类当中所有的Field（了解一下）
 */
public class ReflectTest05 {
    public static void main(String[] args) throws Exception{

        // 获取整个类
        Class studentClass = Class.forName("com.bjpowernode.java.bean.Student");

        //com.bjpowernode.java.bean.Student
        String className = studentClass.getName();
        System.out.println("完整类名：" + className);

        String simpleName = studentClass.getSimpleName();
        System.out.println("简类名：" + simpleName);

        // 获取类中所有的public修饰的Field
        Field[] fields = studentClass.getFields();
        System.out.println(fields.length); // 测试数组中只有1个元素
        // 取出这个Field
        Field f = fields[0];
        // 取出这个Field它的名字
        String fieldName = f.getName();
        System.out.println(fieldName);

        // 获取所有的Field
        Field[] fs = studentClass.getDeclaredFields();
        System.out.println(fs.length); // 4

        System.out.println("==================================");
        // 遍历
        for(Field field : fs){
            // 获取属性的修饰符列表
            int i = field.getModifiers(); // 返回的修饰符是一个数字，每个数字是修饰符的代号！！！
            System.out.println(i);
            // 可以将这个“代号”数字转换成“字符串”吗？
            String modifierString = Modifier.toString(i);
            System.out.println(modifierString);
            // 获取属性的类型
            Class fieldType = field.getType();
            //String fName = fieldType.getName();
            String fName = fieldType.getSimpleName();
            System.out.println(fName);
            // 获取属性的名字
            System.out.println(field.getName());
        }
    }
}
```



#### 访问/修改一个对象的属性

```java
// 使用反射机制，怎么去访问一个对象的属性。（set get）
Class studentClass = Class.forName("com.bjpowernode.java.bean.Student");
Object obj = studentClass.newInstance(); // obj就是Student对象。（底层调用无参数构造方法）

// 获取no属性（根据属性的名称来获取Field）
Field noFiled = studentClass.getDeclaredField("no");

// 给obj对象(Student对象)的no属性赋值
/*
虽然使用了反射机制，但是三要素还是缺一不可：
    要素1：obj对象
    要素2：no属性
    要素3：2222值
注意：反射机制让代码复杂了，但是为了一个“灵活”，这也是值得的。
 */
noFiled.set(obj, 22222); // 给obj对象的no属性赋值2222

// 读取属性的值
// 两个要素：获取obj对象的no属性的值。
System.out.println(noFiled.get(obj));

// 可以访问私有的属性吗？
Field nameField = studentClass.getDeclaredField("name");

// 打破封装（反射机制的缺点：打破封装，可能会给不法分子留下机会！！！）
// 这样设置完之后，在外部也是可以访问private的。
nameField.setAccessible(true);

// 给name属性赋值
nameField.set(obj, "jackson");
// 获取name属性的值
System.out.println(nameField.get(obj));
```



### 调用对象方法

- getDeclaredMethods()获取对象所有的方法
- getMethods()获取公有方法

```java
    public static void main(String[] args) throws Exception{
        // 不使用反射机制，怎么调用方法
        // 创建对象
        UserService userService = new UserService();
        // 调用方法
        /*
        要素分析：
            要素1：对象userService
            要素2：login方法名
            要素3：实参列表
            要素4：返回值
         */
        boolean loginSuccess = userService.login("admin","123");
        //System.out.println(loginSuccess);
        System.out.println(loginSuccess ? "登录成功" : "登录失败");

        // 使用反射机制来调用一个对象的方法该怎么做？
        Class userServiceClass = Class.forName("com.bjpowernode.java.service.UserService");
        // 创建对象
        Object obj = userServiceClass.newInstance();
        // 获取Method
        Method loginMethod = userServiceClass.getDeclaredMethod("login", String.class, String.class);
        //Method loginMethod = userServiceClass.getDeclaredMethod("login", int.class);
        // 调用方法
        // 调用方法有几个要素？ 也需要4要素。
        // 反射机制中最最最最最重要的一个方法，必须记住。
        /*
        四要素：
        loginMethod方法
        obj对象
        "admin","123" 实参
        retValue 返回值
         */
        Object retValue = loginMethod.invoke(obj, "admin","123123");
        System.out.println(retValue);
    }
```



### 调用构造方法实例化java对象

```java
/*
通过反射机制调用构造方法实例化java对象。（这个不是重点）
 */
public class ReflectTest12 {
    public static void main(String[] args) throws Exception{
        // 不使用反射机制怎么创建对象
        Vip v1 = new Vip();
        Vip v2 = new Vip(110, "zhangsan", "2001-10-11", true);

        // 使用反射机制怎么创建对象呢？
        Class c = Class.forName("com.bjpowernode.java.bean.Vip");
        // 调用无参数构造方法
        Object obj = c.newInstance();
        System.out.println(obj);

        // 调用有参数的构造方法怎么办？
        // 第一步：先获取到这个有参数的构造方法
        Constructor con = c.getDeclaredConstructor(int.class, String.class, String.class,boolean.class);
        // 第二步：调用构造方法new对象
        Object newObj = con.newInstance(110, "jackson", "1990-10-11", true);
        System.out.println(newObj);

        // 获取无参数构造方法
        Constructor con2 = c.getDeclaredConstructor();
        Object newObj2 = con2.newInstance();
        System.out.println(newObj2);
    }
}
```



### 获取类的父类和所有接口

```java
/*
重点：给你一个类，怎么获取这个类的父类，已经实现了哪些接口？
 */
public class ReflectTest13 {
    public static void main(String[] args) throws Exception{

        // String举例
        Class stringClass = Class.forName("java.lang.String");

        // 获取String的父类
        Class superClass = stringClass.getSuperclass();
        System.out.println(superClass.getName());

        // 获取String类实现的所有接口（一个类可以实现多个接口。）
        Class[] interfaces = stringClass.getInterfaces();
        for(Class in : interfaces){
            System.out.println(in.getName());
        }
    }
}
```





## 注解

注解是一种引用数据类型，编译后会生成.class文件。



### 注解定义格式

`[修饰符列表] @interface 注解类型名 {  }`



### 注解使用方式

`@注解类型名`  注解可以出现在类上、属性上、方法上、变量上等，注解还可以出现在注解类型上



### JDK内置注解

java.lang 包下的注解：

- **Deprecated** 用 @Deprecated 注释的程序元素（已经过时或者很危险，已经有更好的选择）
- **Override** 表示方法的重写
- SuppressWarnings 指示应该在注释元素（以及包含在该注释元素中的所有程序元素）中取消显示指定的编译器警告



### 元注解（标注注解的注解）

#### Target

用来标注“被标注的注解”可以出现在哪些地方

```java
@Target(ElementType.METHOD)   表示“被标注的注解”只能出现在方法上。
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE}) 表示该注解可以出现在构造方法上、字段上、局部变量上、方法上......类上......
    
    
//Target源代码
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    /**
     * Returns an array of the kinds of elements an annotation type
     * can be applied to.
     * @return an array of the kinds of elements an annotation type
     * can be applied to
     */
    ElementType[] value();
}
```

#### Retention

用来标注“被标注的注解”最终保存在哪里

```java
@Retention(RetentionPolicy.SOURCE)：表示该注解只被保留在java源文件中。
@Retention(RetentionPolicy.CLASS)：表示该注解被保存在class文件中。
@Retention(RetentionPolicy.RUNTIME)：表示该注解被保存在class文件中，并且可以被反射机制所读取。

    
//Retention源代码
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Retention {
    /**
     * Returns the retention policy.
     * @return the retention policy
     */
    RetentionPolicy value();
}
```



### 注解中定义属性

- 属性定义格式：`[属性类型] 属性名();` 

- 注解中定义了属性，如果使用该注解，需要对注解中的所有属性进行赋值，否则会报错；另一种解决办法是在注解属性定义后面加上关键字 `default`

- 注解属性的名字如果是**value**，则在赋值的时候可以省略

  - ```java
    public @interface MyAnnotation {
        /*
        指定一个value属性。
         */
        String value();
    }
    
    
    //以下两种定义方法都可以
    @MyAnnotation(value = "hehe")
    public void doSome(){
    }
    
    @MyAnnotation("haha")	//value可以省略
    public void doOther(){
    }
    
    ```

- 属性 类型可以是

  ```java
  //byte short int long float double boolean char String Class 枚举类型以及以上每一种的数组形式。
  //如果属性是一个数组
  
  // 数组是大括号
  @OtherAnnotation(age = 25, email = {"zhangsan@123.com", "zhangsan@sohu.com"}, seasonArray = Season.WINTER)
  public void doSome(){
  }
  
  // 如果数组中只有1个元素：大括号可以省略。
  @OtherAnnotation(age = 25, email = "zhangsan@123.com", seasonArray = {Season.SPRING, Season.SUMMER})
  public void doOther(){
  }
  ```



### 反射注解

可以通过反射判断类上是否有该注解

1. 获取到这个类，可以使用`Class.forName("****")`
2. 使用`isAnnotationPresent(注解名.class)`判断是否有该注解对象

```java
public class ReflectAnnotationTest {
    public static void main(String[] args) throws Exception{
        // 获取这个类
        Class c = Class.forName("com.bjpowernode.java.annotation5.MyAnnotationTest");
        // 判断类上面是否有@MyAnnotation
        //System.out.println(c.isAnnotationPresent(MyAnnotation.class)); // true
        if(c.isAnnotationPresent(MyAnnotation.class)){
            // 获取该注解对象
            MyAnnotation myAnnotation = (MyAnnotation)c.getAnnotation(MyAnnotation.class);
            //System.out.println("类上面的注解对象" + myAnnotation); // @com.bjpowernode.java.annotation5.MyAnnotation()
            // 获取注解对象的属性怎么办？和调接口没区别。
            String value = myAnnotation.value();
            System.out.println(value);
        }

        // 判断String类上面是否存在这个注解
        Class stringClass = Class.forName("java.lang.String");
        System.out.println(stringClass.isAnnotationPresent(MyAnnotation.class)); // false
    }
}
```



