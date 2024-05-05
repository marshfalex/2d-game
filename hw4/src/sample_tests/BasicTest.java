package sample_tests;

import hw4.SimpleElement;

public class BasicTest {

	public static void main(String[] args) {
		SimpleElement e = new SimpleElement(2.3, 4.5, 10, 20);
		System.out.println(e.getXReal()); // expected 2.3
		System.out.println(e.getXInt()); // expected 2
		System.out.println(e.getYReal()); // expected 4.5
		System.out.println(e.getYInt()); // expected 5
		System.out.println(e.getWidth()); // expected 10
		System.out.println(e.getHeight());// expected 20
		System.out.println(e.getRect());// expected [x=2,y=5,width=10,height=20]
		System.out.println(e.isMarked()); // expected false

		// setting position
		e.setPosition(42, 137);
		System.out.println(e.getXReal()); // expected 42
		System.out.println(e.getYReal()); // expected 137

		// update should increment the frame count
		e.update();
		e.update();
		System.out.println(e.getFrameCount()); // expected 2

		// mark
		e.markForDeletion();
		System.out.println(e.isMarked()); // expected true

		e = new SimpleElement(10, 0, 10, 10);
		SimpleElement e2 = new SimpleElement(1, 5, 10, 10);
		System.out.println(e.collides(e2)); // expected true
		e2.setPosition(0, 5);
		System.out.println(e.collides(e2)); // expected false
	}
}
