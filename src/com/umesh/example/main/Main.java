package com.umesh.example.main;

public class Main {

	public static void main(String[] args) {

		Mathematics math = new Mathematics(20,10);
		System.out.println(math.sub());
		System.out.println(math.sum());
		System.out.println(math.mul());
		//Mathematics.staticSum(20, 10);
	}
}
