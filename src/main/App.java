package main;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangle t1 = new Triangle(6, 6, 6);
		Triangle t2 = new Triangle(6,5,5);
		
		System.out.println(t1.getAire());
		System.out.println(t1.getAngleA());
		System.out.println(t1.getAngleB());
		System.out.println(t1.getAngleC());
		
		if(t2.estEgal(t1)) {
			System.out.println("cest la meme chose");
		}
		
		if(t2.estSemblable(t1)) {
			System.out.println("cest la meme chose 2");
		}
		
		System.out.println(t1.getDescription());
		System.out.println(t2.getDescription());
	}

}




