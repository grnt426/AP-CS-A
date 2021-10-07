package turtlestuff.turtle; /************************************************
 *AUTHOR: NICHOLAS SEWARD
 *LICENSE: BSD (USE THIS HOWEVER YOU SEE FIT.)
 *DATE: 7/19/2011
 *VERSION: 3
 *    .-./*)   .-./*)   .-./*)   .-./*)   .-./*)
 *  _/___\/  _/___\/  _/___\/  _/___\/  _/___\/
 *    U U      U U      U U      U U      U U
 *CONTRIBUTOR: WILL KIMBALL
 *  (ADDED ALPHA CHANNEL CAPABILITIES)
 *SPECIAL THANKS: ROBERT SEDGEWICK AND KEVIN WAYNE
 *  FROM PRINCETON FOR PROVIDING A GREAT TEMPLATE.
 ************************************************/
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The Turtle class allows the user to create turtle graphics.
 * <a href="http://en.wikipedia.org/wiki/Turtle_graphics">http://en.wikipedia.org/wiki/Turtle_graphics</a>
 *
 * @author	Nicholoas Seward <nicholas.seward@gmail.com>
 * @version	1.6
 * @since	2011.0614
 */
public class Turtle {

	private double x = 0, y = 0;     // turtle is at (x, y)
	private double angle = 0;    // facing this many degrees counterclockwise from the x-axis
	private boolean isPenDown = true;
	private int speed = 100;
	private double penSize = 2;
	private Color penColor = Color.BLACK;
	private static Map<String, Color> colorNames;

	public Turtle(int width, int height) {
		screenSize(width, height);
		worldCoordinates(-1 * (width / 2), -1 * (height / 2), width / 2, height / 2);
		colorNames = new HashMap<>();
		colorNames.put("aliceblue", new Color(0xf0f8ff));
		colorNames.put("antiquewhite", new Color(0xfaebd7));
		colorNames.put("aqua", new Color(0x00ffff));
		colorNames.put("aquamarine", new Color(0x7fffd4));
		colorNames.put("azure", new Color(0xf0ffff));
		colorNames.put("beige", new Color(0xf5f5dc));
		colorNames.put("bisque", new Color(0xffe4c4));
		colorNames.put("black", new Color(0x000000));
		colorNames.put("blanchedalmond", new Color(0xffebcd));
		colorNames.put("blue", new Color(0x0000ff));
		colorNames.put("blueviolet", new Color(0x8a2be2));
		colorNames.put("brown", new Color(0xa52a2a));
		colorNames.put("burlywood", new Color(0xdeb887));
		colorNames.put("cadetblue", new Color(0x5f9ea0));
		colorNames.put("chartreuse", new Color(0x7fff00));
		colorNames.put("chocolate", new Color(0xd2691e));
		colorNames.put("coral", new Color(0xff7f50));
		colorNames.put("cornflowerblue", new Color(0x6495ed));
		colorNames.put("cornsilk", new Color(0xfff8dc));
		colorNames.put("crimson", new Color(0xdc143c));
		colorNames.put("cyan", new Color(0x00ffff));
		colorNames.put("darkblue", new Color(0x00008b));
		colorNames.put("darkcyan", new Color(0x008b8b));
		colorNames.put("darkgoldenrod", new Color(0xb8860b));
		colorNames.put("darkgray", new Color(0xa9a9a9));
		colorNames.put("darkgreen", new Color(0x006400));
		colorNames.put("darkkhaki", new Color(0xbdb76b));
		colorNames.put("darkmagenta", new Color(0x8b008b));
		colorNames.put("darkolivegreen", new Color(0x556b2f));
		colorNames.put("darkorange", new Color(0xff8c00));
		colorNames.put("darkorchid", new Color(0x9932cc));
		colorNames.put("darkred", new Color(0x8b0000));
		colorNames.put("darksalmon", new Color(0xe9967a));
		colorNames.put("darkseagreen", new Color(0x8fbc8f));
		colorNames.put("darkslateblue", new Color(0x483d8b));
		colorNames.put("darkslategray", new Color(0x2f4f4f));
		colorNames.put("darkturquoise", new Color(0x00ced1));
		colorNames.put("darkviolet", new Color(0x9400d3));
		colorNames.put("deeppink", new Color(0xff1493));
		colorNames.put("deepskyblue", new Color(0x00bfff));
		colorNames.put("dimgray", new Color(0x696969));
		colorNames.put("dodgerblue", new Color(0x1e90ff));
		colorNames.put("firebrick", new Color(0xb22222));
		colorNames.put("floralwhite", new Color(0xfffaf0));
		colorNames.put("forestgreen", new Color(0x228b22));
		colorNames.put("fuchsia", new Color(0xff00ff));
		colorNames.put("gainsboro", new Color(0xdcdcdc));
		colorNames.put("ghostwhite", new Color(0xf8f8ff));
		colorNames.put("gold", new Color(0xffd700));
		colorNames.put("goldenrod", new Color(0xdaa520));
		colorNames.put("gray", new Color(0x808080));
		colorNames.put("green", new Color(0x008000));
		colorNames.put("greenyellow", new Color(0xadff2f));
		colorNames.put("honeydew", new Color(0xf0fff0));
		colorNames.put("hotpink", new Color(0xff69b4));
		colorNames.put("indianred", new Color(0xcd5c5c));
		colorNames.put("indigo", new Color(0x4b0082));
		colorNames.put("ivory", new Color(0xfffff0));
		colorNames.put("khaki", new Color(0xf0e68c));
		colorNames.put("lavender", new Color(0xe6e6fa));
		colorNames.put("lavenderblush", new Color(0xfff0f5));
		colorNames.put("lawngreen", new Color(0x7cfc00));
		colorNames.put("lemonchiffon", new Color(0xfffacd));
		colorNames.put("lightblue", new Color(0xadd8e6));
		colorNames.put("lightcoral", new Color(0xf08080));
		colorNames.put("lightcyan", new Color(0xe0ffff));
		colorNames.put("lightgoldenrodyellow", new Color(0xfafad2));
		colorNames.put("lightgreen", new Color(0x90ee90));
		colorNames.put("lightgrey", new Color(0xd3d3d3));
		colorNames.put("lightpink", new Color(0xffb6c1));
		colorNames.put("lightsalmon", new Color(0xffa07a));
		colorNames.put("lightseagreen", new Color(0x20b2aa));
		colorNames.put("lightskyblue", new Color(0x87cefa));
		colorNames.put("lightslategray", new Color(0x778899));
		colorNames.put("lightsteelblue", new Color(0xb0c4de));
		colorNames.put("lightyellow", new Color(0xffffe0));
		colorNames.put("lime", new Color(0x00ff00));
		colorNames.put("limegreen", new Color(0x32cd32));
		colorNames.put("linen", new Color(0xfaf0e6));
		colorNames.put("magenta", new Color(0xff00ff));
		colorNames.put("maroon", new Color(0x800000));
		colorNames.put("mediumaquamarine", new Color(0x66cdaa));
		colorNames.put("mediumblue", new Color(0x0000cd));
		colorNames.put("mediumorchid", new Color(0xba55d3));
		colorNames.put("mediumpurple", new Color(0x9370db));
		colorNames.put("mediumseagreen", new Color(0x3cb371));
		colorNames.put("mediumslateblue", new Color(0x7b68ee));
		colorNames.put("mediumspringgreen", new Color(0x00fa9a));
		colorNames.put("mediumturquoise", new Color(0x48d1cc));
		colorNames.put("mediumvioletred", new Color(0xc71585));
		colorNames.put("midnightblue", new Color(0x191970));
		colorNames.put("mintcream", new Color(0xf5fffa));
		colorNames.put("mistyrose", new Color(0xffe4e1));
		colorNames.put("moccasin", new Color(0xffe4b5));
		colorNames.put("navajowhite", new Color(0xffdead));
		colorNames.put("navy", new Color(0x000080));
		colorNames.put("oldlace", new Color(0xfdf5e6));
		colorNames.put("olive", new Color(0x808000));
		colorNames.put("olivedrab", new Color(0x6b8e23));
		colorNames.put("orange", new Color(0xffa500));
		colorNames.put("orangered", new Color(0xff4500));
		colorNames.put("orchid", new Color(0xda70d6));
		colorNames.put("palegoldenrod", new Color(0xeee8aa));
		colorNames.put("palegreen", new Color(0x98fb98));
		colorNames.put("paleturquoise", new Color(0xafeeee));
		colorNames.put("palevioletred", new Color(0xdb7093));
		colorNames.put("papayawhip", new Color(0xffefd5));
		colorNames.put("peachpuff", new Color(0xffdab9));
		colorNames.put("peru", new Color(0xcd853f));
		colorNames.put("pink", new Color(0xffc0cb));
		colorNames.put("plum", new Color(0xdda0dd));
		colorNames.put("powderblue", new Color(0xb0e0e6));
		colorNames.put("purple", new Color(0x800080));
		colorNames.put("red", new Color(0xff0000));
		colorNames.put("rosybrown", new Color(0xbc8f8f));
		colorNames.put("royalblue", new Color(0x4169e1));
		colorNames.put("saddlebrown", new Color(0x8b4513));
		colorNames.put("salmon", new Color(0xfa8072));
		colorNames.put("sandybrown", new Color(0xf4a460));
		colorNames.put("seagreen", new Color(0x2e8b57));
		colorNames.put("seashell", new Color(0xfff5ee));
		colorNames.put("sienna", new Color(0xa0522d));
		colorNames.put("silver", new Color(0xc0c0c0));
		colorNames.put("skyblue", new Color(0x87ceeb));
		colorNames.put("slateblue", new Color(0x6a5acd));
		colorNames.put("slategray", new Color(0x708090));
		colorNames.put("snow", new Color(0xfffafa));
		colorNames.put("springgreen", new Color(0x00ff7f));
		colorNames.put("steelblue", new Color(0x4682b4));
		colorNames.put("tan", new Color(0xd2b48c));
		colorNames.put("teal", new Color(0x008080));
		colorNames.put("thistle", new Color(0xd8bfd8));
		colorNames.put("tomato", new Color(0xff6347));
		colorNames.put("turquoise", new Color(0x40e0d0));
		colorNames.put("violet", new Color(0xee82ee));
		colorNames.put("wheat", new Color(0xf5deb3));
		colorNames.put("white", new Color(0xffffff));
		colorNames.put("whitesmoke", new Color(0xf5f5f5));
		colorNames.put("yellow", new Color(0xffff00));
		colorNames.put("yellowgreen", new Color(0x9acd32));
	}

	/**
	 * Picks the Turtle's tail up so it won't draw on the screen as it moves.
	 */
	public void up() {
		isPenDown = false;
	}

	/**
	 * Lowers the Turtle's tail down so it will draw on the screen as it moves.
	 */
	public void down() {
		isPenDown = true;
	}

	/**
	 * Rotates the Turtle counterclockwise.
	 *
	 * @param delta an angle in degrees.
	 */
	public void left(double delta) {
		angle += delta;
		angle %= 360;
	}

	/**
	 * Rotates the Turtle clockwise.
	 *
	 * @param delta an angle in degrees.
	 */
	public void right(double delta) {
		angle -= delta;
		angle %= 360;
	}

	/**
	 * Moves the Turtle forward.
	 *
	 * @param step a distance measured in pixels.
	 */
	public void forward(double step) {
		double oldx = x;
		double oldy = y;
		x += step * Math.cos(Math.toRadians(angle));
		y += step * Math.sin(Math.toRadians(angle));
		ScreenDraw.setPenColor(penColor);
		ScreenDraw.setPenRadius(penSize / 512);
		if (isPenDown) {
			ScreenDraw.line(oldx, oldy, x, y);
		}
		delay(speed);
	}

	/**
	 * Places a dot at the Turtle's present position.
	 */
	public void dot() {
		ScreenDraw.setPenRadius(Math.max(penSize + 4, penSize * 2) / 512);
		ScreenDraw.line(x, y, x, y);
		ScreenDraw.setPenRadius(penSize / 512);
		delay(speed);
	}

	/**
	 * Places a dot at the Turtle's present position.
	 *
	 * @param size the width in pixels.
	 */
	public void dot(double size) {
		ScreenDraw.setPenRadius(size / 512);
		ScreenDraw.line(x, y, x, y);
		ScreenDraw.setPenRadius(penSize / 512);
		delay(speed);
	}

	/**
	 * Places a dot at the Turtle's present position.
	 *
	 * @param size the width in pixels.
	 * @param color name of a color or a 6-digit hex color string (e.g. "00FF00" for green)
	 */
	public void dot(double size, String color) {
		ScreenDraw.setPenColor(getColor(color));
		ScreenDraw.setPenRadius(size / 512);
		ScreenDraw.line(x, y, x, y);
		ScreenDraw.setPenColor(penColor);
		ScreenDraw.setPenRadius(penSize / 512);
		delay(speed);
	}

	/**
	 * Places a dot at the Turtle's present position.
	 *
	 * @param color name of a color or a 6-digit hex color string (e.g. "00FF00" for green)
	 */
	public void dot(String color) {
		ScreenDraw.setPenColor(getColor(color));
		ScreenDraw.setPenRadius(Math.max(penSize + 4, penSize * 2) / 512);
		ScreenDraw.line(x, y, x, y);
		ScreenDraw.setPenColor(penColor);
		ScreenDraw.setPenRadius(penSize / 512);
		delay(speed);
	}

	/**
	 * Write text centered a the Turtle's current position.
	 *
	 * @param text message to be written on the screen.
	 */
	public void write(String text) {
		ScreenDraw.text(x, y, text);
		delay(speed);
	}

	/**
	 * Write text centered a the Turtle's current position.
	 *
	 * @param text message to be written on the screen.
	 * @param angle the angle in degrees that the text is rotated counterclockwise.
	 */
	public void write(String text, double angle) {
		ScreenDraw.text(x, y, text, angle);
		delay(speed);
	}

	/**
	 * Write text on the screen.
	 *
	 * @param x the x coordinate of the center of the text.
	 * @param y the y coordinate of the center of the text.
	 * @param text message to be written on the screen.
	 * @param angle the angle in degrees that the text is rotated counterclockwise.
	 */
	public void write(double x, double y, String text, double angle) {
		ScreenDraw.text(x, y, text, angle);
		delay(speed);
	}

	/**
	 * Sets the delay in milliseconds between execution of Turtle commands.
	 *
	 * @param t the delay in milliseconds.
	 */
	public void speed(int t) {
		speed = t;
	}

	/**
	 * Moves the Turtle backwards.
	 *
	 * @param step a distance measured in pixels.
	 */
	public void backward(double step) {
		forward(-step);
	}

	/**
	 * Moves the Turtle to a specified position.  This will result in a line being drawn if the tail is down.
	 *
	 * @param x x coordinate.
	 * @param y y coordinate.
	 */
	public void goTo(double x, double y) {
		ScreenDraw.setPenColor(penColor);
		ScreenDraw.setPenRadius(penSize / 512);
		if (isPenDown) {
			ScreenDraw.line(this.x, this.y, x, y);
		}
		this.x = x;
		this.y = y;
		delay(speed);
	}

	/**
	 * Rotates the Turtle to a specified heading. (0 is right. 90 is up.)
	 *
	 * @param angle heading in degrees.
	 */
	public void face(double angle) {
		this.angle = angle;
		this.angle %= 360;
	}

	/**
	 * Returns the Turtle to position (0,0) with a heading of 0 degrees.
	 */
	public void home() {
		goTo(0, 0);
		face(0);
	}

	/**
	 * Pauses the program.
	 *
	 * @param t pause in milliseconds
	 */
	public void delay(int t) {
		ScreenDraw.show(t);
	}

	/**
	 * Sets the color that the Turtle draws with.
	 *
	 * @param color name of a color or a 6-digit hex color string (e.g. "00FF00" for green)
	 */
	public void penColor(String color) {
		penColor = getColor(color);
		ScreenDraw.setPenColor(penColor);
	}

	/**
	 * Sets the color that the Turtle draws with, allows custom colors.
	 *
	 * @param red red as value between 0 - 255
	 * @param green green as value between 0 - 255
	 * @param blue blue as value between 0 - 255
	 */
	public void penColor(int red, int green, int blue) {
		penColor = new Color(red, green, blue);
		ScreenDraw.setPenColor(penColor);
	}

	/**
	 * Sets the color that the Turtle draws with, allows custom colors with alpha channel.
	 *
	 * @param red red as value between 0 - 255
	 * @param green green as value between 0 - 255
	 * @param blue blue as value between 0 - 255
	 * @param alpha alpha as value between 0 - 255
	 */
	public void penColor(int red, int green, int blue, int alpha) {
		penColor = new Color(red, green, blue, alpha);
		ScreenDraw.setPenColor(penColor);
	}

	/**
	 * Sets the opacity of the color that the Turtle draws with.
	 *
	 * @param alpha alpha value between 0 - 255 to set as opacity of new pen color
	 */
	public void setOpacity(int alpha) {
		Color oldColor = ScreenDraw.getPenColor();
		penColor = new Color(oldColor.getRed(), oldColor.getGreen(), oldColor.getBlue(), alpha);
		ScreenDraw.setPenColor(penColor);
	}

	/**
	 * Sets the line width that the Turtle draws.
	 *
	 * @param size line width in pixels
	 */
	public void penSize(double size) {
		penSize = size;
	}

	/**
	 * Gets the x coordinate.
	 *
	 * @return x coordinate
	 */
	public double x() {
		return x;
	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return y coordinate
	 */
	public double y() {
		return y;
	}

	/**
	 * Gets the heading.
	 *
	 * @return the angle that the Turtle is facing in degrees. (0 is right. 90 is up.)
	 */
	public double heading() {
		return angle;
	}

	/**
	 * Gets the distance between the Turtle's position and another specified position.
	 *
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public double distance(double x, double y) {
		return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
	}

	/**
	 * Gets the heading if the Turtle was facing the specified position. (0 is right. 90 is up.)
	 *
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public double heading(double x, double y) {
		return (180 * Math.atan2(y - this.y, x - this.x) / Math.PI) % 360;
	}

	/**
	 * Checks to see if the Turtle's tail is down.
	 *
	 * @return true if the Turtle's tail is down.
	 */
	public boolean isDown() {
		return isPenDown;
	}

	/**
	 * Clears the screen to white.
	 */
	public void clear() {
		ScreenDraw.clear();
		delay(speed);
	}

	/**
	 * Clears the screen to a color.
	 *
	 * @param color name of a color or a 6-digit hex color string (e.g. "00FF00" for green)
	 */
	public void clear(String color) {
		ScreenDraw.clear(getColor(color));
		delay(speed);
	}

	private Color getColor(String color) {
		Color c = Color.RED;
		color = color.replaceAll("_", "").replaceAll(" ", "").toLowerCase();
		if (colorNames.containsKey(color)) {
			c = colorNames.get(color);
		} else {
			try {
				c = new Color(Integer.parseInt(color, 16));
			} catch (Exception e2) {
				System.out.println("The turtle doesn't know what " + color + " is so the turtle picked red for you.");
			}
		}
		return c;
	}

	/**
	 * Resizes the drawable area of the window.
	 *
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public void screenSize(int width, int height) {
		ScreenDraw.setCanvasSize(width, height);
	}

	/**
	 * Sets the what Turtle position will be at the bottom-left and the top-right of the screen.
	 *
	 * @param minx x coordinate of the left side of the screen.
	 * @param miny y coordinate of the bottom of the screen.
	 * @param maxx x coordinate of the right side of the screen.
	 * @param maxy y coordinate of the top of the screen.
	 */
	public void worldCoordinates(double minx, double miny, double maxx, double maxy) {
		ScreenDraw.setXscale(minx, maxx);
		ScreenDraw.setYscale(miny, maxy);
	}

	/**
	 * Saves the screen to a PNG image.
	 *
	 * @param filename the filename of the image excluding the extension. (e.g. "myImage" instead of "myImage.PNG")
	 */
	public void save(String filename) {
		ScreenDraw.save(filename + ".PNG");
	}

	/**
	 * Closes and exits the program.
	 */
	public void bye() {
		System.exit(0);
	}

	/**
	 * Allows the user to type what they want the Turtle to do while the Turtle window is up.
	 */
	public void interactiveMode() {
		System.out.println("Welcome to the turtle's interactive mode.  Options: e(x)it,(h)elp.");

		Scanner sc = new Scanner(System.in);
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		engine.put("Turtle", this);
		while (true) {
			String s = sc.nextLine();
			if (s.equals("x")) {
				break;
			}
			if (s.equals("h")) {
				Class c = (new Turtle(640, 480)).getClass();
				Method m[] = c.getDeclaredMethods();
				for (int i = 0; i < m.length; i++) {
					if (m[i].getModifiers() % 2 == 1 && !m[i].getName().equals("main")) {
						System.out.print(m[i].getName() + "(");
						Class t[] = m[i].getParameterTypes();
						for (int j = 0; j < t.length; j++) {
							System.out.print(t[j].getName().replaceAll("java.lang.String", "String"));
							if (j < t.length - 1) {
								System.out.print(",");
							}
						}
						System.out.print(")   ");
					}
				}
				System.out.println("");
				continue;
			}
			s = "Turtle." + s;
			try {
				engine.eval("msg=" + s);
				engine.eval("println('The turtle obeys.');if(msg) println('The turtle feels compelled to say '+msg+'.  I hope that makes more sense to you.');");
			} catch (Exception e) {
				System.out.println("The turtle is confused. Options: e(x)it,(h)elp.");
				//System.out.println(e+"\n"+s);
			}
		}
		sc.close();
		System.out.println("The turtle is no longer interactive from this console.");
	}

	/**
	 * Turtle demo.
	 *
	 * @param args commandline arguments
	 */
	public static void main(String[] args) {
		Turtle bob = new Turtle(640, 480);
		bob.speed(10);
		for (int i = 0; i < 360; i++) {
			bob.forward(i * 1.25);
			bob.left(90.25);
		}
		bob.interactiveMode();
	}
}
