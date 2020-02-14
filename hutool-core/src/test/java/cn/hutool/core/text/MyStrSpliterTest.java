package cn.hutool.core.text;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * StrBuilder单元测试
 * @author looly
 *
 */
public class MyStrSpliterTest {

	@Test
	public void SplitTest(){
		StrSpliter strSpliter = new StrSpliter();
		Pattern p = Pattern.compile(",");
		List<String> result = strSpliter.split("a,b,c", ",", 3, false, false, false);
		List<String> result2 = strSpliter.split("a,b,c", p, 3, false, false);
		List<String> expect1 = Arrays.asList("a", "b", "c");
		List<String> expect2 = Arrays.asList("a", "b", "c");
		Assert.assertEquals(expect1, result);
		Assert.assertEquals(expect2, result2);
	}

	@Test
	public void SplitTest_null_separator(){
		StrSpliter strSpliter = new StrSpliter();
		Pattern p = Pattern.compile("");
		List<String> result = strSpliter.split("a,b,c", "", 3, false, false, false);
		List<String> result2 = strSpliter.split("a,b,c", p, 1, false, false);
		List<String> expect = Arrays.asList("a,b,c");;
		Assert.assertEquals(expect, result);
		Assert.assertEquals(expect, result2);
	}

	@Test
	public void SplitTest_limit_1(){
		StrSpliter strSpliter = new StrSpliter();
		List<String> result = strSpliter.split("a,b,c", ",", 1, false, false, false);
		List<String> expect = Arrays.asList("a,b,c");
		Assert.assertEquals(expect, result);
	}

	@Test
	public void SplitTest_null_str(){
		StrSpliter strSpliter = new StrSpliter();
		Pattern p = Pattern.compile(",");
		List<String> result = strSpliter.split("", ",", 3, false, false, false);
		List<String> result2 = strSpliter.split("", p, 1, false, false);
		ArrayList<String> expect = new ArrayList<String>();
		Assert.assertEquals(expect, result);
		Assert.assertEquals(expect, result2);
	}

	@Test
	public void SplitTest_complex_separator(){
		StrSpliter strSpliter = new StrSpliter();
		List<String> result = strSpliter.split("a..b..c", "..", 3, false, false, false);
		ArrayList<String> expect = new ArrayList<String>();
		expect.add("a");
		expect.add("b");
		expect.add("c");
		Assert.assertEquals(expect, result);
	}

	@Test
	public void splitByLengthTest(){
		StrSpliter strSpliter = new StrSpliter();
		String[] result = strSpliter.splitByLength("ab", 1);
		String[] expect = {"a","b"};
		Assert.assertEquals(expect, result);
	}

}
