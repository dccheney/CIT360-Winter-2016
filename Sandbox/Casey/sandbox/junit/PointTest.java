package sandbox.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PointTest {
	private Point p1;

	@BeforeClass
	public void setUp() {
		p1 = new Point();
	}
	
	
	@Test
	public void test() {
		assertTrue(true);
	}

}
