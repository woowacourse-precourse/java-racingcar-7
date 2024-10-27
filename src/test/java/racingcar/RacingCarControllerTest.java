package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarControllerTest {

    RacingCarController racingCarController = new RacingCarController();

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("자동차의 이름들 중 5글자 이상인 이름이 있으면 예외 처리")
    void getCarInfoExceptionTest() {
        // given
        String input = "car1,car2,car1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.getCarInfo();
        });
    }

    @Test
    @DisplayName("자동차 이름들이 모두 5글자 이하이면 정상적으로 Map객체를 반환")
    void getCarInfoTest() {
        // given
        String input = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Map<String, Integer> carInfo = racingCarController.getCarInfo();

        // then
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            assertThat(carInfo.containsKey(carName)).isTrue();
        }
        assertThat(carInfo.size()).isEqualTo(carNames.length);
    }

    @Test
    @DisplayName("입력이 정수가 아닐 경우 예외 처리")
    void getAttemptCountExceptionTest() {
        // given
        String input = "5.1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.getAttemptCount();
        });
    }

    @Test
    @DisplayName("입력이 정수일 경우 정상적으로 정수 반환")
    void getAttemptCountTest() {
        // given
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when & then
        assertThat(racingCarController.getAttemptCount()).isEqualTo(5);
    }
}
