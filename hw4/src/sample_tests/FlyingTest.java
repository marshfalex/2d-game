package sample_tests;

import hw4.FlyingElement;

public class FlyingTest {
	public static void main(String[] args) {
		FlyingElement p = new FlyingElement(0, 0, 0, 0);
		p.setGrounded(false);
		p.setVelocity(2, 3);
		p.update();
		System.out.println(p.getYReal()); // expected 3
		System.out.println(p.getDeltaY());// expected 3
		p.update();
		System.out.println(p.getYReal()); // expected 6
		System.out.println(p.getDeltaY());// expected 3
		p.setGravity(5);
		p.update();
		System.out.println(p.getYReal()); // 6 + 3 = 9
		System.out.println(p.getDeltaY()); // 3 + 5 = 8
		p.setGrounded(true);
		p.update();
		System.out.println(p.getYReal()); // 9 + 8 = 17
		System.out.println(p.getDeltaY()); // 8 (grounded)
		p.update();
		System.out.println(p.getYReal()); // 17 + 8 = 25
		System.out.println(p.getDeltaY()); // 8 (grounded)
	}
}
