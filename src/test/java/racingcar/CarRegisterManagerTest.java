package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarRegisterManagerTest {

    private final CarRegisterManager carRegisterManager = new CarRegisterManager();

    @Test
    void 구분자로_분리된_이름으로_레이싱카를_등록한다() {
        //given
        String cars = "pobi,woni,jun";

        //when
        RacingCars racingCars = carRegisterManager.registerRacingCars(cars);

        //then
        assertThat(racingCars.getCars()).hasSize(3);
    }

    @Test
    void 구분자_없이_하나의_레이싱카를_등록한다() {
        //given
        String cars = "pobi";

        //when
        RacingCars racingCars = carRegisterManager.registerRacingCars(cars);

        //then
        assertThat(racingCars.getCars()).hasSize(1);
    }
}
