package net.acmicpc.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import net.acmicpc.problem.Solution.Rectangle;

public class P2669Test {

	@Test
	public void test() {
		Rectangle test = new Rectangle(0, 0, 5),
				test2 = new Rectangle(3, 3, 5),
				crossed = test.getCrossedRectangle(test2);
		
		assertEquals(crossed.getArea(), 4);
	}

}
