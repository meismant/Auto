package utils;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

/**
 * Created by mac-250 on 2/26/16.
 */
public class Reporter implements IReporter {
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for (ISuite suite: suites){
            String suiteName = suite.getName();
            Map suiteResults = suite.getResults();
           // for (ISuiteResult sr: suiteResults.values()){

        }
    }
}
