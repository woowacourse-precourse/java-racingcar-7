package racingcar;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {

    @DisplayName("이름 분할 테스트")
    @ParameterizedTest
    @CsvSource({
        "'woni,pobi','pobi','woni'",
        "pobi,woni,hyuuuun,test,code,singi"

    })
    void inputCarNames(String input , String... testNames) {


        View view = new View();

        List<String> result = view.inputCarNames(input);

        List<String> test = Arrays.asList(testNames);

        // 결과 검증
        assertEquals(test, result);
    }

}
