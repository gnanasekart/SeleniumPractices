package NewPack;

import java.util.ArrayList;

class A{
public void m3()
{
System.out.println("A");
}
}

class B{
public void m3()
{
System.out.println("B");
}
}

class Cc
{
public void m3()
{
System.out.println("C");
}
}

public class TypeCastDemo {
ArrayList<Object> a = new ArrayList<>();
	public static void main(String[] args) {
		
	Cc c = new Cc();
	c.m3();
	
	//((B)c).m3();
	Cc b = new Cc();
	
	
	
	}
}
