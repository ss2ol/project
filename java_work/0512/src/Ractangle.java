
public class Ractangle extends Shape {
	
	Point start;
	int width;
	int height;
	
	
	public Ractangle() {
		
	}
	
	public Ractangle(int x, int y, int width, int height) {
//	super(color);
	start = new Point (x,y);
	this.width = width;
	this.height = height;
	}
	

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("[사각형 :색 -" + getColor()+ ",시작점-" +getStart() + ",가로-" + width + ",세로-" +height+ "]");
	}

	

}
