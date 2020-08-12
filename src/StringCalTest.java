import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalTest {

	@Test
	void test1() {
		String number = "0,1,2";

		String expected = "3";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test2() {
		String number = "0";

		String expected = "0";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test3() {
		String number = "1.3,1.9,7.8,6.0";

		String expected = "17.0";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test4() {
		String number = "1.3,2,5";

		String expected = "8.3";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test5() {
		String number = "-1,8";

		String expected = "Negative not allowed: -1";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test6() {
		String number = "2,-4,-5";

		String expected = "Negative not allowed: -4,-5";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test7() {
		String number = "\n1|2|3";

		String expected = "6";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test8() {
		String number = "\n1.5|2.5|3";

		String expected = "7.0";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test9() {
		String number = "1.5;\n10;3";

		String expected = "14.5";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test10() {
		String number = "20\n5\n8\n10";

		String expected = "43";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test11() {
		String number = "3,5,";

		String expected = "Number expected but EOF found";

		assertEquals(expected, StringCal.add(number));
	}

	@Test
	void test12() {
		String number = "-1,,2";
		String expected = "Negative not allowed: -1\nNumber expected but ',' found at position 3";
		assertEquals(expected, StringCal.add(number));
	}

}
