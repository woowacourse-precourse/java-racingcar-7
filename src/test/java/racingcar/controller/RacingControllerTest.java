package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class RacingControllerTest {

    Car pobiCar, woniCar;
    Race race;

    @BeforeEach
    void setUp() {
        pobiCar = new Car("pobi");
        woniCar = new Car("woni");
    }

    @Test
    @DisplayName("입력받은 자동차 이름 및 이동 횟수를 Race에 저장한다.")
    void Race_설정_테스트() {
        // when
        race = new Race(3, new Cars(List.of(pobiCar, woniCar)));

        // then
        assertThat(race.getCount()).isEqualTo(3);
        assertThat(race.getCars().getCarList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("이동 횟수만큼 randomNum에 따라 각 자동차를 이동시킨다.")
    void 횟수만큼_자동차_이동_테스트() {
        // when
        pobiCar.updatePosition(2);
        woniCar.updatePosition(7);

        // then
        assertThat(pobiCar.getPosition()).isEqualTo(0);
        assertThat(woniCar.getPosition()).isEqualTo(1);
    }

}
