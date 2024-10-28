package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class RacingServiceTest {
    @RepeatedTest(100)
    void 랜덤_범위_테스트() {
        RacingService service = new RacingService(Arrays.asList(new Car("test")));
        int randomNumber = service.getRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void 최고_점수_가져오기_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(4);
        RacingService service = new RacingService(Arrays.asList(car1, car2));
        assertThat(service.getTopScore()).isEqualTo(1);
    }

    @Test
    void 우승자_가져오기_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(4);
        RacingService service = new RacingService(Arrays.asList(car1, car2));
        List<String> winners = service.getWinner();
        assertThat(winners).contains("car1");
    }
}
