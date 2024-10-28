package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.interfaces.winner.WinnerResponse;

class JudgeServiceTest {

    @Test
    void judgeWinnerTest() throws NoSuchFieldException, IllegalAccessException {
        JudgeService judgeService = new JudgeService();
        Cars cars = new Cars();
        Car honda = new Car("honda");
        Car bmw = new Car("bmw");
        Car benz = new Car("benz");
        Car ford = new Car("ford");
        cars.registerCar(honda);
        cars.registerCar(bmw);
        cars.registerCar(benz);
        cars.registerCar(ford);

        Field carPositionField = Car.class.getDeclaredField("carPosition");
        carPositionField.setAccessible(true);
        carPositionField.setInt(honda, 10);
        carPositionField.setInt(bmw, 5);
        carPositionField.setInt(benz, 8);
        carPositionField.setInt(ford, 10);

        WinnerResponse winnerResponse = judgeService.judgeWinner(cars);
        assertThat(winnerResponse.winnerList()).isEqualTo("최종 우승자 : honda, ford");
    }
}
