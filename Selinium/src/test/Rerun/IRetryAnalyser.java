package test.Rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyser implements IRetryAnalyzer{

	int count=0;
	int limit= 4;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limit) {
			count++;
			return true;
		}
		
		return false;
	}

	
}
