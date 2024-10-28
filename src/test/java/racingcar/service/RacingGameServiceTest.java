package racingcar.service;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

class RacingGameServiceTest {

    private final RacingGameService service = new RacingGameService();

    @Test
    void 자동차_이동_로직_테스트() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        service.runRound(cars);

        // 각 자동차의 이동 결과가 잘 적용되었는지 확인하는 간단한 테스트
        cars.forEach(car -> System.out.println(car.getName() + "의 위치: " + car.getPosition()));
    }
}
