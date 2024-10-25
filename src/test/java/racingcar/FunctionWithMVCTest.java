package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MoveNumber;

public class FunctionWithMVCTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 이름이_공백이거나_빈칸이면_예외(String testName) {
        assertThatThrownBy(() -> new Car(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,holy,pobi"})
    void 중복_이름이면_예외(String testName) {
        assertThatThrownBy(() -> new Cars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiholymoly"})
    void 이름이_5자리_초과면_예외(String testName) {
        assertThatThrownBy(() -> new Car(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자리 이하로 입력해주세요.");
    }

    @Test
    void 차_개수가_1개_이하면_예외() {
        String testName = "pobi";
        assertThatThrownBy(() -> new Cars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2개 이상의 차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 이동_횟수가_1이하면_예외(String testNumber) {
        assertThatThrownBy(() -> new MoveNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1회 이상의 이동 횟수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1", "8.8", "1.0"})
    void 이동_횟수가_정수가_아니면_예외(String testNumber) {
        assertThatThrownBy(() -> new MoveNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수로 된 이동 횟수를 입력해주세요.");
    }

    @Test
    void 차_전진_또는_정지() {
        String testName = "pobi,holy";
        int testRandomNumberForPobi = 4;
        int testRandomNumberForHoly = 0;
        Cars cars = new Cars(testName);

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars();
                    assertThat(cars.getCars().get(0).getMoveDistance()).isEqualTo(1);
                    assertThat(cars.getCars().get(1).getMoveDistance()).isEqualTo(0);
                },
                testRandomNumberForPobi, testRandomNumberForHoly
        );
    }

    @Test
    void 우승자_1대_반환() {
        String testWinnerName = "pobi";
        String testLoserName = "holy";
        int testRandomNumberForWinner = 4;
        int testRandomNumberForLoser = 0;
        Cars cars = new Cars(testWinnerName + "," + testLoserName);

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars();
                    List<String> winnerNames = cars.findWinnerNames();
                    assertThat(winnerNames.size()).isEqualTo(1);
                    assertThat(winnerNames.get(0)).isEqualTo(testWinnerName);
                },
                testRandomNumberForWinner, testRandomNumberForLoser
        );
    }

}
