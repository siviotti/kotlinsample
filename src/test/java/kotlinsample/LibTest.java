package kotlinsample;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.*;

public class LibTest {

	@Test
	public void test() {
		assertEquals(5, LibKt.add(2, 3));
	}

}
