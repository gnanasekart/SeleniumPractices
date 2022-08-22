package DP_Bridge;

public class Square extends Shape {

	public Square(Color color) {
		super(color);
	}

	@Override
	public String fill() {
		return "circle filled with color "+color.fill();
	}

}
