package NewPack;
public class InstanceFlowBase {
int x = 1;
public void base1()
{
	m1();
System.out.println("first static base");
}

InstanceFlowBase()
{
System.out.println("Constructor");	
}

public static void main(String[] args) 
{
	InstanceFlowBase in = new InstanceFlowBase();
	in.m1();
System.out.println("main method base");
}
public void m1()
{
System.out.println(y);
System.out.println("m1 method base");
}
public void base2()
{
System.out.println("second static base");
}
int y = 2;
}