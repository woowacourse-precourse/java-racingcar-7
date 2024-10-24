package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarMessageUtilsTest {

    @Test
    void TDD_숫자를_문자_경주_기호로_변환() {
        //given
        int position = 5;

        //when
        String positionMessage = RacingCarMessageUtils.convertSymbolByPosition(position);

        //then
        assertThat(positionMessage).isEqualTo("-----");
    }

    @Test
    void TDD_자동차_이름_위치_메세지_변환() {
        //given
        String carName = "pobi";
        RacingCar racingCar = new RacingCar(carName);

        // 2번 전진
        racingCar.move(5);
        racingCar.move(3);
        racingCar.move(4);

        //when
        String carNamePositionMessage = RacingCarMessageUtils.carNamePositionMessage(racingCar);

        //then
        assertThat(carNamePositionMessage).isEqualTo("pobi : --");
    }

    @Test
    void TDD_자동차_여러대_이름_위치_메세지_변환() {
        //given
        String carName = "pobi,woni";
        RacingCars racingCars = RacingCars.from(carName);

        racingCars.getCars()
                .stream()
                .filter(car -> car.getName().equals("pobi"))
                .forEach(car -> car.move(5));

        //when
        String message = RacingCarMessageUtils.carsResultMessage(racingCars);

        //then
        System.out.println(message);
    }
}
