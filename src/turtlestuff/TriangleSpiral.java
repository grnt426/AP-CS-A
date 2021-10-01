package turtlestuff;

public class TriangleSpiral {

	public static void main(String[] args) throws InterruptedException {
		Turtle t = new Turtle(1300, 1300);
		t.left(90);
		t.speed(50);

		// Draw triangular
		drawSpiral(t, 121, 4, 1.0, 600);
//
//		// Draw Square
//		drawSpiral(t, 91, 3, 1.0, 700);
//
//		// Draw Hexagonal
//		drawSpiral(t, 61, 3, .3, 800);

		// Draw Pentagon
//		drawSpiral(t, 71, 3, .5, 800);
	}

	public static void drawSpiral(Turtle t, int angle, int step, double stepFactor, int lines) {
		for(int i = 0; i < lines; i++) {
			t.forward(step * i * stepFactor);
			t.left(angle);
		}
	}
}
