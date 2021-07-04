package test.Rerun;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class RetryTestCases {

	
	@Test//(retryAnalyzer = IRetryAnalyser.class)
	void test1() {
		assertEquals(true, false);
	}
	@Test//(retryAnalyzer = IRetryAnalyser.class)
	void test2() {
		assertEquals(true, true);
	}
}
