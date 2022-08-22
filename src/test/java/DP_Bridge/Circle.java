package DP_Bridge;

public class Circle extends Shape {

	public Circle(Color color) {
		super(color);
	}

	@Override
	public String fill() {
		return "Square filled with color "+color.fill();
	}

}
