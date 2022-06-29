
public class ShapeSet {
	static Shape[] shapes = new Shape[10];
	static int ShapesCnt;
	
	public static void drawShapes() {
		for (int i=0; i< ShapesCnt; i++) {
			shapes[i].draw();
		}
	}
	
	
	public static void main(String[] args) {
		shapes[ShapesCnt++]= new Circle(5,5,10);
		shapes[ShapesCnt++]= new Triangle(10,10,20,20,30,30);
		shapes[ShapesCnt++]= new Ractangle(10,10,20,30);
		drawShapes();

	}

}
