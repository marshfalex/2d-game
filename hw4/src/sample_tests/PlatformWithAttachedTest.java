package sample_tests;

import hw4.AttachedElement;
import hw4.PlatformElement;

public class PlatformWithAttachedTest {

	public static void main(String[] args) {
		// left side at x = 50, width 10, right side at 60
		PlatformElement p = new PlatformElement(50, 200, 10, 10);
		p.setBounds(40, 70);
		p.setVelocity(6, 0);

		// size 5 x 5, offset 2 units from left of platform, 15 above
		AttachedElement c = new AttachedElement(5, 5, 2, 15);

		// this should automatically make p the base of c
		p.addAssociated(c);

		// x position should be the base position + 2 = 52
		// y position should be base y - attached element height - hover = 180
		System.out.println(c.getXReal()); // expected 52
		System.out.println(c.getYReal()); // expected 180
		p.update();
		System.out.println(c.getXReal()); // expected 58
		System.out.println(c.getYReal()); // expected 180
		p.update();
		System.out.println(c.getXReal()); // expected 62
		System.out.println(c.getYReal()); // expected 180

		// calling update on p should update associated elements too
		System.out.println(c.getFrameCount()); // expected 2
	}

}
