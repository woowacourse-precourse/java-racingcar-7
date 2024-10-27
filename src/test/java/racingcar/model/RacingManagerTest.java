package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingManagerTest {
    private List<Car> cars;

    @Test
    @DisplayName("시도 횟수 값만큼 라운드 실행 및 결과 출력")
    void playAndDisplayRounds_withTryCount() {
        int tryCount = 5;
        cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        RacingManager racingManager = new RacingManager(cars, tryCount);
        racingManager.playRounds();

        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }

        System.out.print("최종 우승자 : " + racingManager.getWinners());
    }
}
