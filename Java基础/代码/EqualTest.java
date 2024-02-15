public class EqualTest{
	public static void main(String[] args){
		int a=100;
		int b=100;

		//���Ϊa==b
		System.out.println((a==b)?"a==b":"a!=b");

		Person p1=new Person();
		p1.id=101;
		p1.name="wang";

		Person p2=new Person();
		p2.id=101;
		p2.name="wang";

		//���Ϊp1!=p2 �Ƚϵ���������������õ�ַ
		System.out.println((p1 == p2)?"p1==p2":"p1!=p2");
		System.out.println((p1.equals(p2))?"p1 equals p2":"p1 not equals p2");

		String s1="abc";
		String s2="abc";
		//���s1==s2
		//System.out.println((s1==s2)?"s1==s2":"s1=s2");

		String s3 = new String("abc");
		String s4 = new String("abc");
		//���s3!=s4
		System.out.println((s3==s4)?"s3==s4":"s3!=s4");
		System.out.println((s3.equals(s4))?"s3 equals s4":"s3 not equals s4");

	}
}
class Person{
	int id;
	String name;
}