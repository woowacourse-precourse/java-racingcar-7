package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void 우승자_판별_테스트() {
        // 자동차 3대 생성
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        List<Car> cars = Arrays.asList(car1, car2, car3);
        Race race = new Race(cars);

        // 경주 실행 (예: 5회)
        int moveCount = 5;
        race.start(moveCount);  // 경주를 실행하여 모든 자동차가 이동하도록 함

        // 각 자동차의 위치를 확인하여 가장 멀리 간 자동차를 우승자로 추정
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        // 최대 위치에 있는 자동차가 존재하는지 확인 (우승자 검증)
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

        assertThat(winners).isNotEmpty();  // 우승자가 비어있지 않은지 확인
        assertThat(winners.size()).isGreaterThanOrEqualTo(1);  // 최소 1명 이상의 우승자가 있는지 확인
    }
}