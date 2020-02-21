package cn.hutool.core.codec;

import org.junit.Assert;
import org.junit.Test;

public class MyMorseTest {
	
	private final MyMorse myMorse = new MyMorse();

	@Test
	public void testNewEncode() {
		String text = "Hello World!";
		String morse = "...././.-../.-../---/-...../.--/---/.-./.-../-../-.-.--/";
		final StringBuilder stringBuilder = new StringBuilder();
		Assert.assertEquals(morse, myMorse.encode(text, stringBuilder));
		Assert.assertEquals(myMorse.decode(morse), text.toUpperCase());
	}

}
