package Practices.SeleniumDemo;


public class lambdademo {

	//lambda functions without params
	static int year = 2020; 
	public static void main(String[] args) {

		Drawable draw = (leng, bred) ->(leng*bred);
		System.out.println(draw.draw(10, 20));

		//	Drawable draw = ()->System.out.println("drawing " +year);

		//		Drawable draw1 = new Drawable() {
		//			@Override
		//			public void draw() {
		//				System.out.println("drawing");	
		//			}
		//		};
		//		draw1.draw();	
	}	
	}

interface Drawable
{
	int draw(int length, int breath);
}
