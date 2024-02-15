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