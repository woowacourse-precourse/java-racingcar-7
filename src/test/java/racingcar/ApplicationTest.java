package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("기능_테스트 number 1")
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("getCarInput 테스트")
    void getCarInputTest() {
        String input = "car1,car2,car3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = Application.getCarInput();
        assertThat(result).isEqualTo("car1,car2,car3");
    }

    @Test
    @DisplayName("splitInput 작동테스트")
    void splitInputTest() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("car1"));
        cars.add(new RacingCar("car2"));
        cars.add(new RacingCar("car3"));
        List<RacingCar> resultCars = Application.splitInput("car1,car2,car3");
        assertThat(resultCars).extracting("name").containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("splitInput 글자수 예외테스트")
    void splitInputTest2() {
        List<RacingCar> cars = new ArrayList<>();
        assertThatThrownBy(() -> Application.splitInput("car1,car2,car333"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("getTrial 글자수 정상 작동 테스트")
    void getTrialTest() {
        String input = "5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer result = Application.getTrial();
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름이 5 이상일 때")
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
