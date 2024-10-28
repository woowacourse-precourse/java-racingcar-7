package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputParserTest {

    InputParser inputParser = new InputParser();

    @Test
    void 자동차_이름_파싱_테스트() {
        String carName = "pobi,woni";
        assertSimpleTest(
                () -> {
                    List<Car> car = inputParser.parseCarName(carName);
                    assertThat(car.get(0).getCarName()).isEqualTo("pobi");
                    assertThat(car.get(1).getCarName()).isEqualTo("woni");
                }
        );
    }

    @Test
    void 시도횟수_파싱_테스트() {
        String attemptNumber = "3";
        assertSimpleTest(
                () -> {
                    int number = inputParser.parseAttemptNumber(attemptNumber);
                    assertThat(number).isEqualTo(3);
                }
        );
    }

    @Test
    void 자동차이름_파싱_예외_테스트_null일때() {
        String carName = "";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputParser.parseCarName(carName))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_파싱_예외_테스트_길이() {
        String carName = "eunhee,pobi";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputParser.parseCarName(carName))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_파싱_예외_테스트() {
        String attemptNumber = "number";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputParser.parseAttemptNumber(attemptNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
