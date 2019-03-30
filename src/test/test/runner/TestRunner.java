package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/test/features/"},
        glue = {"test.steps"},
        tags = {"@wip"},
        format = {"pretty"}
)

public class TestRunner {
/*
   private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner()
    }

    @Test
    public void runTests(){
        new TestNGCucumberRunner(getClass()).runCukes();
    }*/

}
