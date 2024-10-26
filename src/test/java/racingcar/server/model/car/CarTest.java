package racingcar.server.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.server.model.car.Car;
import racingcar.server.helper.CarHelper;

public class CarTest {

    @Test
    @DisplayName("중간 진행 사항 확인")
    void checkLapChart() {
        // given
        String name = "JAVA";
        long remainingLap = 6L;
        String position = "---";
        Car sut = CarHelper.mock(name, remainingLap, position);

        // when
        String actual = sut.myProgressSummary();

        // then
        String expected = String.format("%s : %s", name, position);
        assertThat(actual.equals(expected)).isTrue();
    }
}
