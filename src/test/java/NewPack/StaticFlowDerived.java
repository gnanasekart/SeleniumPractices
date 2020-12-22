package NewPack;

public class StaticFlowDerived extends StaticFlowBase {
	static int i = 100;
	static
	{
		m2();
	System.out.println("first static derived");
	}
	public static void main(String[] args) 
	{
	m1();
	System.out.println("main method derived");
	}
	public static void m2()
	{
		System.out.println(j);
	System.out.println("m2 method derived");
	}
	static
	{
	System.out.println("second static derived");
	}
	static int j = 200;
}
