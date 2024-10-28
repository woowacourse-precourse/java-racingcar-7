package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.game.RacingController;
import racing.game.RacingService;
import racing.game.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private final RacingController racingController = new RacingController();
    private final RacingService racingService = new RacingService();

    @Test
    @DisplayName("전진 기능 : 자동차가 전진하는 경우")
    void 기능_테스트_1 (){
        // given
        Car car = new Car("test");
        int initPosition = car.getPosition();

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(initPosition + 1);
    }

    @Test
    @DisplayName("우승자 1명 선정 기능: 최대 위치를 가진 자동차 이름 반환")
    void 기능_테스트_2(){
        // given
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        List<Car> cars = List.of(car1, car2);

        // when
        car1.moveForward();
        List<String> winners = racingService.getWinnerNames(cars);

        // then
        assertThat(winners).containsExactly("test1");
    }

    @Test
    @DisplayName("우승자 여러명 선정 기능: 최대 위치를 가진 자동차 이름 반환")
    void 기능_테스트_3(){
        // given
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");
        List<Car> cars = List.of(car1, car2, car3);

        // when
        car1.moveForward();
        car2.moveForward();
        List<String> winners = racingService.getWinnerNames(cars);

        // then
        assertThat(winners).containsExactlyInAnyOrder("test1", "test2");
    }

    @Test
    @DisplayName("자동차 생성 기능: 자동차 이름 리스트로 자동차 객체 생성")
    void 기능_테스트_4(){
        // given
        List<String> carNames = List.of("test1", "test2", "test3");

        // when
        List<Car> cars = racingController.createCars(carNames);

        // then
        assertThat(cars).hasSize(3);
        assertThat(carNames).containsExactlyInAnyOrder("test1", "test2", "test3");
    }


}
