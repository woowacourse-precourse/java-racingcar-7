package racingcar.stadium;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.car.Cars;

class CarRegisterManagerTest {

    private final CarRegisterManager carRegisterManager = new CarRegisterManager();

    @Test
    void 구분자로_분리된_이름으로_경주할_차를_등록한다() {
        //given
        String carNames = "pobi,woni,jun";

        //when
        Cars cars = carRegisterManager.register(carNames);

        //then
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 구분자_없이_하나의_자동차를_등록한다() {
        //given
        String carNames = "pobi";

        //when
        Cars cars = carRegisterManager.register(carNames);

        //then
        assertThat(cars.getCars()).hasSize(1);
    }
}
