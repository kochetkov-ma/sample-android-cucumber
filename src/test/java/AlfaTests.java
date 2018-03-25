import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"ru.mk.pump.cucumber.plugin.PumpCucumberPlugin"},
        glue = {"ru.mk.pump.cucumber","steps"},
        features = "classpath:features/")
public class AlfaTests {
}
