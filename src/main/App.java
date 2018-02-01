package main;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangle t1 = new Triangle(2.0002, 3.0001, 4.0001);
		Triangle t2 = new Triangle(2.0001, 3.0001, 4.0001);
		
		System.out.println(t1.getAire());
		System.out.println(t1.getAngleA());
		System.out.println(t1.getAngleB());
		System.out.println(t1.getAngleC());
		
		if(t2.estEgal(t1)) {
			System.out.println("cest la meme chose");
		}
		
	}

}




