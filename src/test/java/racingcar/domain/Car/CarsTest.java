package racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.randomnumber.RandomIntegerGenerator;
import racingcar.domain.randomnumber.RandomNumberGenerator;
import racingcar.exceptions.DuplicateNameException;

class CarsTest {

    private final RandomNumberGenerator<Integer> forwardGenerator = new RandomIntegerGenerator(4, 9);
    private final RandomNumberGenerator<Integer> stopGenerator = new RandomIntegerGenerator(0, 3);
    private Cars moveCars;
    private Cars stopCars;


    @BeforeEach
    void setUp() {
        moveCars = new Cars(forwardGenerator);
        stopCars = new Cars(stopGenerator);
        String[] initialMoveCars = {"pobi", "woni", "crong"};
        moveCars.addCar(initialMoveCars);
        String[] initialStopCars = {"che", "java", "903"};
        stopCars.addCar(initialStopCars);
    }

    @Test
    void 중복_이름_예외_테스트() {
        // given
        String[] duplicateNames = {"pobi"};

        // when & then
        assertThatThrownBy(() -> moveCars.addCar(duplicateNames))
                .isInstanceOf(DuplicateNameException.class);
    }

    @Test
    void 이동_테스트() {
        // when
        moveCars.moveForward();

        // then
        for (Car car : moveCars.getWinners()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 정지_테스트() {
        // when
        stopCars.moveForward();

        // then
        for (Car car : moveCars.getWinners()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    void 우승자_반환_테스트() {
        // given
        moveCars.moveForward();
        String[] cars = {"che", "java", "903"};
        moveCars.addCar(cars);
        List<Car> winners = moveCars.getWinners();

        // then
        assertThat(winners).hasSize(3);
        assertThat(moveCars.getSize()).isEqualTo(6);
    }
}
