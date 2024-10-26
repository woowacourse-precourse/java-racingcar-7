package racingcar.message.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.converter.StringToRacingCarsConverter;
import racingcar.domain.RacingCar;

import java.util.LinkedHashSet;

public class CarPositionMessageUtilsTest {

    StringToRacingCarsConverter stringToRacingCarsConverter;

    @BeforeEach
    void before() {
        stringToRacingCarsConverter = new StringToRacingCarsConverter();
    }

    @Test
    void TDD_자동차_여러대_이름_위치_메세지_변환() {
        //given
        String carName = "pobi,woni";
        LinkedHashSet<RacingCar> cars = stringToRacingCarsConverter.convert(carName);

        cars.stream()
                .filter(car -> car.getName().equals("pobi"))
                .forEach(car -> car.move(5));

        //when
        String message = CarPositionMessageUtils.generateCarsPositionMessage(cars);

        //then
        System.out.println(message);
    }
}
