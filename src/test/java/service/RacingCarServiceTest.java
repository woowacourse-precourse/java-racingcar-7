package service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest {

    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @Test
    void playSingleRoundTest() {
        // Given: 자동차 리스트 생성
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));

        // When: 단일 라운드 실행
        racingCarService.playSingleRound(cars);

        // Then: 자동차들이 전진하거나 멈추는지 확인
        // 자동차의 위치가 모두 0 이상인지 확인 (위치는 0이거나 그 이상이어야 함)
        assertThat(cars).allMatch(car -> car.getPosition() >= 0);
    }

    @Test
    void findFinalWinnersTest() {
        // 서로 다른 위치에 있는 자동차 리스트 생성
        Car car1 = new Car("car1");
        car1.move();

        Car car2 = new Car("car2");
        car2.move();

        Car car3 = new Car("car3");

        List<Car> cars = Arrays.asList(car1, car2, car3);

        // 우승자 찾기
        List<String> winners = racingCarService.findFinalWinners(cars);

        assertThat(winners).containsExactlyInAnyOrder("car1", "car2");
    }

    @Test
    void SingleWinnerTest() {
        // 우승자가 하나인 경우
        Car car1 = new Car("car1");
        car1.move();
        car1.move();

        Car car2 = new Car("car2");
        car2.move();  //

        List<Car> cars = Arrays.asList(car1, car2);

        List<String> winners = racingCarService.findFinalWinners(cars);

        assertThat(winners).containsExactly("car1");
    }

    @Test
    void isPrintAllowedTest() {
        // 출력 가능 여부 테스트
        assertThat(racingCarService.isPrintAllowed(500)).isTrue();  // 500은 허용 범위 내
        assertThat(racingCarService.isPrintAllowed(1000)).isTrue(); // 1000도 허용 범위 내
        assertThat(racingCarService.isPrintAllowed(1001)).isFalse(); // 1001은 허용되지 않음
    }
}
