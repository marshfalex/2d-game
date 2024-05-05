package sample_tests;

import hw4.PlatformElement;

public class PlatformTest {

	public static void main(String[] args) {
		// left side at x = 50, width 10, right side at 60
		PlatformElement p = new PlatformElement(50, 200, 10, 10);
		p.setBounds(40, 70);
		p.setVelocity(6, 0);
		p.update();
		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [56, 66]
		System.out.println("Velocity " + p.getDeltaX()); // 6.0
		p.update();
		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [60, 70]
		System.out.println("Velocity " + p.getDeltaX()); // -6.0
		p.update();
		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [54, 64]
		System.out.println("Velocity " + p.getDeltaX()); // -6.0
		p.update();
		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [48, 58]
		System.out.println("Velocity " + p.getDeltaX()); // -6.0
		p.update();
		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [42, 52]
		System.out.println("Velocity " + p.getDeltaX()); // -6.0
		p.update();
		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [40, 50]
		System.out.println("Velocity " + p.getDeltaX()); // 6.0
	}

}
