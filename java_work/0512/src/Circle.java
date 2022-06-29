
public class Circle extends Shape {
	Point center;
	int radius;

	public Circle() {

	}

	public Circle(int x, int y, int radius) {
		center = new Point(x, y);
		this.radius = radius;
	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("[원 :색 -" + getColor() + "[원 :중신점 -" + getCenter() + ",반지름 -" + getRadius() + "]");
	}

}
