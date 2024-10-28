package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ProgrammingRequirementTest extends NsTest {

    private static final String JAVA_VERSION_PROPERTY = "java.version";

    @Test
    public void JDK_21_버전에서_실행_가능해야_한다() {
        String javaVersion = System.getProperty(JAVA_VERSION_PROPERTY);
        assertTrue(javaVersion.startsWith("21"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
