package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PersonalApplicationTest extends NsTest {

    private static CarInitializer carInitializer;
    private static final Duration TIMEOUT_LIMIT = Duration.ofSeconds(1L);

    @ParameterizedTest
    @CsvFileSource(resources = "/splitCarNameStringTestFile.csv")
    void 자동차_이름_테스트(String inputValue, String expected) {
        List<String> nameList = carInitializer.splitCarNameString(inputValue);
        Assertions.assertEquals(expected, nameList.toString());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TimeOutTestFile.csv")
    void 수행_시간_테스트(String inputValue, String progressCount) {
        Assertions.assertTimeoutPreemptively(TIMEOUT_LIMIT, () -> {
            run(inputValue, progressCount);
        });
    }


    @BeforeAll
    static void setup() {
        carInitializer = new CarInitializer();
    }

    @AfterAll
    static void afterAll() {
        carInitializer = null; // 참조 해제를 통한 GC 대상 지정.
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
