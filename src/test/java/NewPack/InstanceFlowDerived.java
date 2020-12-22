package NewPack;
public class InstanceFlowDerived extends InstanceFlowBase {
int i = 100;
public void base1()
{
	m2();
System.out.println("instance derived");
}

InstanceFlowDerived()
{
System.out.println("derived Constructor");	
}

public static void main(String[] args) 
{
	InstanceFlowDerived in = new InstanceFlowDerived();
	in.m2();
System.out.println("main method derived");
}
public void m2()
{
System.out.println(j);
System.out.println("m2 method derived");
}
public void base2()
{
System.out.println("second derived");
}
int j = 200;
}