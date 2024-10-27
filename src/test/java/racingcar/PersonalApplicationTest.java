package racingcar;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PersonalApplicationTest {

    private static InitMapClass initMapClass;

    @ParameterizedTest
    @CsvFileSource(resources = "/splitCarNameStringTestFile.csv")
    void 자동차_이름_테스트(String inputValue, String expected) {
        List<String> nameList = initMapClass.splitCarNameString(inputValue);
        Assertions.assertEquals(expected, nameList.toString());
    }

    @BeforeAll
    static void setup() {
        initMapClass = new InitMapClass();
    }

    @AfterAll
    static void afterAll() {
        initMapClass = null; // 참조 해제를 통한 GC 대상 지정.
    }
}
