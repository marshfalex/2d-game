package sample_tests;

import hw4.FollowerElement;
import hw4.PlatformElement;

public class PlatformWithFollowerTest {

	public static void main(String[] args) {
		// first try an example where the base doesn't move
		// left side at x = 50, width 10, right side at 60
		PlatformElement b = new PlatformElement(50, 200, 10, 10);
		b.setBounds(40, 70);

		// size 5 x 5, initial offset 2 units from left of platform
		FollowerElement e = new FollowerElement(5, 5, 2);
		e.setVelocity(2, 0);

		// this should automatically make b the base of e
		// and the left and right sides of b the boundaries of e
		b.addAssociated(e);
		System.out.println(e.getMin()); // 50
		System.out.println(e.getMax()); // 60

		// x position should be the base position + 2 = 52
		// y position should be base y - follower height = 195
		System.out.println(e.getXReal()); // expected 52
		System.out.println(e.getYReal()); // expected 195

		// platform doesn't move here, but follower does
		b.update();
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 54, 59
		System.out.println(e.getDeltaX()); // expected 2.0
		b.update();
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 55, 60
		System.out.println(e.getDeltaX()); // expected -2.0
		System.out.println();

		// next, what if platform is moving, but follower velocity is 0?
		// left side at x = 50, width 10, right side at 60
		b = new PlatformElement(50, 200, 10, 10);
		b.setBounds(40, 70);
		b.setVelocity(3, 0);

		// size 5 x 5, initial offset 2 units from left of platform
		e = new FollowerElement(5, 5, 2);
		b.addAssociated(e);
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 52, 57

		// when b moves, the boundaries of e should shift
		b.update();
		System.out.println("bounds " + e.getMin() + ", " + e.getMax()); // 53, 63

		// but e is still 2 units from left side
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 55, 60
		System.out.println();

		// next, what if platform is moving, and follower velocity is nonzero?
		// left side at x = 50, width 10, right side at 60
		b = new PlatformElement(50, 200, 10, 10);
		b.setBounds(40, 70);
		b.setVelocity(3, 0);

		// size 5 x 5, initial offset 2 units from left of platform
		e = new FollowerElement(5, 5, 2);
		e.setVelocity(2, 0);
		b.addAssociated(e);
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 52, 57

		b.update();
		// e is now 4 units from left bound, since its velocity is 2
		System.out.println("bounds " + e.getMin() + ", " + e.getMax()); // 53, 63
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // 57, 62

		b.update();
		// b has moved to [56, 66], e attempts to move another 2 units
		// relative to b, to [62, 67], but hits the right boundary at 66
		// and reverses direction
		System.out.println("bounds " + e.getMin() + ", " + e.getMax()); // 56, 66
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // 61, 66
		System.out.println("velocity " + e.getDeltaX()); // expected -2
	}

}
