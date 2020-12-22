package NewPack;
public class StaticFlowBase {
static int x = 1;
static
{
	m1();
System.out.println("first static base");
}
public static void main(String[] args) 
{
m1();
System.out.println("main method base");
}
public static void m1()
{
	System.out.println(y);
System.out.println("m1 method base");
}
static{
System.out.println("second static base");
}
static int y = 2;
}