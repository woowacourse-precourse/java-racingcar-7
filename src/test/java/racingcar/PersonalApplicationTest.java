package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import generator.TestCSVFileGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
public class PersonalApplicationTest extends NsTest {

    private static CarInitializer carInitializer;

    @ParameterizedTest
    @CsvFileSource(resources = "/splitCarNameStringTestFile.csv")
    void 자동차_이름_테스트(String inputValue, String expected) {
        List<String> nameList = carInitializer.splitCarNameString(inputValue);
        Assertions.assertEquals(expected, nameList.toString());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TimeOutTestFile.csv")
    void 수행_시간_테스트(String inputValue, String progressCount) {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1L), () -> {
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
