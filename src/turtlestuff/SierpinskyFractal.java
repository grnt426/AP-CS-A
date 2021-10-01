package turtlestuff;

public class SierpinskyFractal {

	private final Turtle t;

	public SierpinskyFractal(Turtle t) {
		this.t = t;
	}

	public static void main(String[] args) {
		Turtle t = new Turtle(1300, 1300);
		t.speed(0);
		SierpinskyFractal sf = new SierpinskyFractal(t);
		sf.fractal(-600, -500, 1200, 6);
	}

	public void fractal(int x, int y, int length, int level) {
		if(level == 0) {
			t.up();
			t.goTo(x, y);
			t.down();
			t.forward(length);
			t.left(120);
			t.forward(length);
			t.left(120);
			t.forward(length);
			t.left(120);

			return;
		}

		length /= 2;
		level--;

		fractal(x, y, length, level);
		fractal(x + length / 2, (int) (y + (1.0/2.0 * Math.sqrt(3) * length)), length, level); // replace with thing in turtlestuff.Turtle that calcs step for y
		fractal(x + length, y, length, level);
	}
}
