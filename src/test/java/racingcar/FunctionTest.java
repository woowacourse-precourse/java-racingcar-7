package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "pobi,", ",pobi", "pobi,,lulu", "pobi,  ,lulu"})
    void 이름이_공백이거나_빈칸이면_예외(String testName) {
        assertThatThrownBy(() -> Application.validateCarNameIsNotBlank(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
    }
    @Test
    void 중복_이름이면_예외() {
        String testName = "pobi,holy,pobi";

        assertThatThrownBy(() -> Application.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobiholymoly"})
    void 이름이_1자리_미만_또는_5자리_초과면_예외(String testName) {
        //" ", "holy," 등은 처리 x
        assertThatThrownBy(() -> Application.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자리 이상 5자리 이하로 입력해주세요.");
    }

    @Test
    void 차_개수가_1개_이하면_예외() {
        String testName = "pobi";

        assertThatThrownBy(() -> Application.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2개 이상의 차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 이동_횟수가_1이하면_예외(String testNumber) {
        assertThatThrownBy(() -> Application.validateMoveNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1회 이상의 이동 횟수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1", "8.8", "1.0"})
    void 이동_횟수가_정수가_아니면_예외(String testNumber) {
        assertThatThrownBy(() -> Application.validateMoveNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수로 된 이동 횟수를 입력해주세요.");
    }

    @Test
    void 차_전진_또는_정지() {
        String testName1 = "pobi";
        String testName2 = "holy";
        int testRandomNumberForPobi = 4;
        int testRandomNumberForHoly = 0;
        Map<String, Integer> cars = new HashMap<>();
        cars.put(testName1, 0);
        cars.put(testName2, 0);

        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                () -> {
                    Map<String, Integer> carsAfterRace = Application.doRaceAndPrintRaceStatus(cars, 1);
                    assertThat(carsAfterRace.get(testName1)).isEqualTo(1);
                    assertThat(carsAfterRace.get(testName2)).isEqualTo(0);
                },
                testRandomNumberForPobi, testRandomNumberForHoly
        );
    }

    @Test
    void 우승자_1대_반환() {
        String testWinnerName = "pobi";
        String testLoserName = "holy";
        Map<String, Integer> cars = new HashMap<>();
        cars.put(testWinnerName, 5);
        cars.put(testLoserName, 1);

        List<String> winnerNames = Application.findRaceWinners(cars);

        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames.get(0)).isEqualTo(testWinnerName);
    }

    @Test
    void 우승자_2대_반환() {
        String testWinnerName1 = "pobi";
        String testWinnerName2 = "moly";
        String testLoserName = "holy";
        Map<String, Integer> cars = new HashMap<>();
        cars.put(testWinnerName1, 5);
        cars.put(testWinnerName2, 5);
        cars.put(testLoserName, 1);

        List<String> winnerNames = Application.findRaceWinners(cars);

        assertThat(winnerNames.size()).isEqualTo(2);
    }
}
