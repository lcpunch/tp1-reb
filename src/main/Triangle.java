package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangle {
	
	double coteAB, coteBC, coteCA;
	
	public Triangle() {
		
		this.coteAB = 1;
		this.coteBC = 1;
		this.coteCA = 1;
	}

	/**
	 * @param coteAB
	 * @param coteBC
	 * @param coteCA
	 * @brief Le constructeur de la classe
	 */
	public Triangle(double coteAB, double coteBC, double coteCA) {
		
		this.coteAB = coteAB;
		this.coteBC = coteBC;
		this.coteCA = coteCA;
		
		this.verifyTriangle();
		
	}
	
	private void verifyTriangle() {
		
		if((this.convertToFormat(this.getAngleA() + this.getAngleB() + this.getAngleC()) != this.convertToFormat(Math.PI)) 
				|| this.coteAB <= 0
				|| this.coteBC <= 0
				|| this.coteCA <= 0) {
			try {
				throw new Exception("Les cotes ne font pas un triangle");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public double getAire() {
		
		double delta = (this.coteAB + this.coteBC + this.coteCA) / 2;
		
		double deltaAB = delta - this.coteAB;
		double deltaBC = delta - this.coteBC;
		double deltaCA = delta - this.coteCA;
		
		double produit = delta * deltaAB * deltaBC * deltaCA;
		
		double aire = Math.sqrt(produit);
		
		return aire;
	}
	
	public double getPerimetre() {
		
		return this.coteAB + this.coteBC + this.coteCA;
	}
	
	void setCotes(double coteAB, double coteBC, double coteCA) {
		
		this.coteAB = coteAB;
		this.coteBC = coteBC;
		this.coteCA = coteCA;
		
		this.verifyTriangle();
	}
	
	public double getAngleA() {
		
		double cosAup = Math.pow(this.coteCA, 2)  + Math.pow(this.coteAB, 2) - Math.pow(this.coteBC, 2);
		
		double cosA = cosAup / ( 2 * this.coteCA * this.coteAB);
		double A = Math.acos(cosA);
		
		return A;
	}
	public double getAngleB() {
		
		double cosBup = Math.pow(this.coteAB, 2)  + Math.pow(this.coteBC, 2) - Math.pow(this.coteCA, 2);
		
		double cosB = cosBup / ( 2 * this.coteAB * this.coteBC);
		double B = Math.acos(cosB);
		
		return B;
	}
	public double getAngleC() {
		
		double cosCup = Math.pow(this.coteBC, 2)  + Math.pow(this.coteCA, 2) - Math.pow(this.coteAB, 2);
		
		double cosC = cosCup / ( 2 * this.coteBC * this.coteCA);
		double C = Math.acos(cosC);
		
		return C;
	}
	
	public double getCoteAB() {
		return this.coteAB;
	}
	
	public double getCoteBC() {
		return this.coteBC;
	}
	
	public double getCoteCA() {
		return this.coteCA;
	}
	
	private double convertToFormat(double number) {
		
		return Math.abs(Double.parseDouble(String.format("%.4f", number)));
		
	}
	
	private boolean compare(double a, double b) {
		
		return (this.convertToFormat(this.convertToFormat(a) - this.convertToFormat(b)) > 0.0001);
		
	}
	
	public boolean estEgal(Triangle triangle) {

		Triangle other = (Triangle) triangle;
		
		double [] arr1 = {this.convertToFormat(this.coteAB), this.convertToFormat(this.coteBC), this.convertToFormat(this.coteCA), this.convertToFormat(this.coteAB), this.convertToFormat(this.coteBC), this.convertToFormat(this.coteCA)};
		double [] arr2 = {this.convertToFormat(other.coteAB), this.convertToFormat(other.coteBC), this.convertToFormat(other.coteCA)};
		
		List<double[]> list1 = Arrays.asList(arr1);
		List<double[]> list2 = Arrays.asList(arr2);

		if(list1.containsAll(list2)) {
		      System.out.println("Yo Yo ! They are there !");
		}
		return Arrays.asList(arr1).contains(arr2);
	}
	
	
	
	boolean estSemblable(Triangle triangle) {
		
		double[] angles = {this.convertToFormat(this.getAngleA()), this.convertToFormat(this.getAngleB()), this.convertToFormat(this.getAngleC())};
		double[] otherAngles = {this.convertToFormat(triangle.getAngleA()), this.convertToFormat(triangle.getAngleB()), this.convertToFormat(triangle.getAngleC())};

		Arrays.sort(angles);
		Arrays.sort(otherAngles);
		
		return (Arrays.equals(angles, otherAngles));
	}
	
	public String getDescription() {
		
		if (this.coteAB <= 0 || this.coteBC <= 0 || this.coteCA <= 0) return "Invalide"; // added test
	    if (this.coteAB == this.coteBC && this.coteBC == this.coteCA) return "Equilaterale";
	    if (this.coteAB >= this.coteBC + this.coteCA || this.coteCA >= this.coteBC + this.coteCA || this.coteBC >= this.coteAB + this.coteCA) return "Invalide";
	    if (this.coteBC == this.coteCA || this.coteAB==this.coteBC || this.coteCA==this.coteAB) {
	    		
	    		if(Math.toDegrees(this.getAngleA()) == 90 
		    		|| Math.toDegrees(this.getAngleB()) == 90
		    		|| Math.toDegrees(this.getAngleB()) == 90) {
		    	
		    		return "Isosceles retangle";
		    }
	    	
	    		return "Isosceles";
	    }
	    
	    if(Math.toDegrees(this.getAngleA()) == 90 
	    		|| Math.toDegrees(this.getAngleB()) == 90
	    		|| Math.toDegrees(this.getAngleB()) == 90) {
	    	
	    		return "Scalene retangle";
	    }
	    
	    return "Scalene";
	}
}
