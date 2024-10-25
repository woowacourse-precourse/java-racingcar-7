package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;

public class CarTest extends NsTest {
    @ParameterizedTest
    @DisplayName("자동차가 제대로 나아가는지 확인합니다.")
    @CsvSource({
            "3, 0",
            "4, 1",
            "9, 1",
            "2, 0"
    })
    void car_테스트(int randomNumber, int answer) {
        CarRacer carRacer = new CarRacer("거북이");
        Car testCar = new Car(carRacer);
        testCar.decideToGo(randomNumber);

        assertThat(testCar.getDistance()).isEqualTo(answer);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
