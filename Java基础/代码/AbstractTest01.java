public class AbstractTest01{
	public static void main(String[] args){
		//抽象类不能被实例化 需要被继承
		//Person p = new Person();
		Person p = new Employee();
		p.setName("wqq");
		System.out.println(p.getName());

		String s1=new String ("abc");
		String s2=new String("abc");
		System.out.println(s1==s2);
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
}

class Employee extends Person{

}

class Student extends Person{

}