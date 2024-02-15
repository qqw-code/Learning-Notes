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