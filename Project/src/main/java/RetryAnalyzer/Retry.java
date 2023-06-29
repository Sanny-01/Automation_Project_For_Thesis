package RetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private static int count = 0;
    private static final int maxTry = 3;


    @Override
    public boolean retry(ITestResult result){
        if (count < maxTry){
            count++;
            return true;
        }
        return false;
    }
}


//       if (!result.isSuccess()){
//        if (count < maxTry){
//            count++;
//            result.setStatus(ITestResult.FAILURE);
//            return true;
//        }else{
//            result.setStatus(ITestResult.FAILURE);
//        }
//    }
//        else{
//        result.setStatus(ITestResult.SUCCESS);
//    }
//        return false;
//}