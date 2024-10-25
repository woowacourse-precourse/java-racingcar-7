package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;

import java.util.List;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름으로 경주에 참가할 자동차를 등록한다.")
    void registerCars() {
        //given
        List<String> carNames = List.of("kobe", "james", "tim", "curry");
        RacingCars racingCars = new RacingCars();

        //when
        racingCars.registerCars(carNames);
        List<CarStatusDto> status = racingCars.getStatus();

        //then
        for (int i = 0; i < carNames.size(); i++) {
            Assertions.assertThat(status.get(i).getName()).isEqualTo(carNames.get(i));
        }
    }
}