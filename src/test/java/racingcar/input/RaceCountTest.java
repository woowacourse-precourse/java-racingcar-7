package racingcar.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import racingcar.util.RaceCountValidator;

public class RaceCountTest {

    @Test
    void 이동가능_횟수가_범위_외인_경우_예외_테스트() {
        예외_실행("0", "경주 횟수는 한 번 이상 2147483647 이하 입니다.");
        예외_실행("2147483648", "경주 횟수를 정수로 입력하세요.");
        예외_실행("-1", "경주 횟수는 한 번 이상 2147483647 이하 입니다.");
        예외_실행("1.1", "경주 횟수를 정수로 입력하세요.");
        예외_실행("한번", "경주 횟수를 정수로 입력하세요.");
        예외_실행("one", "경주 횟수를 정수로 입력하세요.");
    }

    @Test
    void 빈_입력_예외_테스트() {
        예외_실행("\n", "입력이 비어 있습니다.");
        예외_실행(" ", "입력이 비어 있습니다.");
    }


    void 예외_실행(String raceCount, String errorMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> RaceCountValidator.validate(raceCount));
        assertEquals(errorMessage, exception.getMessage());
    }


}
