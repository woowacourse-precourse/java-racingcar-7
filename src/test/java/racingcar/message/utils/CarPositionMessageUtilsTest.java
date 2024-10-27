package racingcar.message.utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.RacingConstant.RACING_CAR_MOVE_LIMIT;

public class CarPositionMessageUtilsTest {

    @Test
    void TDD_자동차_여러대_이름_위치_메세지_변환() {
        //given
        RacingCar pobi = new RacingCar("pobi");
        RacingCar woni = new RacingCar("woni");

        pobi.move(RACING_CAR_MOVE_LIMIT);

        LinkedHashSet<RacingCar> cars = Stream.of(pobi, woni).collect(toCollection(LinkedHashSet::new));

        //when
        String message = CarPositionMessageUtils.generateCarsPositionMessage(cars);

        //then
        assertThat(message).isEqualTo("pobi : -\nwoni : \n");
    }
}
