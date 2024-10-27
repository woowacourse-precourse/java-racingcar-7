package racingcar.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.RaceCountValidator;

public class RaceCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 이동가능_횟수가_범위_외인_경우_예외_테스트1(String input) {
        예외_실행(input, "경주 횟수는 한 번 이상 2147483647 이하 입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "1.1", "한번", "one"})
    void 이동가능_횟수가_범위_외인_경우_예외_테스트2(String input) {
        예외_실행(input, "경주 횟수를 정수로 입력하세요.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"\n", " "})
    void 빈_입력_예외_테스트(String input) {
        예외_실행(input, "입력이 비어 있습니다.");
    }


    void 예외_실행(String raceCount, String errorMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> RaceCountValidator.validate(raceCount));
        assertEquals(errorMessage, exception.getMessage());
    }


}
