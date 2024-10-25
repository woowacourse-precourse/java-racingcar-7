package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.NumberGenerator;
import racingcar.service.RandomNumberGenerator;

class CarServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private CarService carService;

    @Test
    void 차량_생성_테스트() {
        carService = new CarService(randomNumberGenerator);
        List<Car> cars = carService.createCars(new String[]{"pobi", "woni", "jun"});
        assertThat(cars).hasSize(3).extracting("carName").containsExactly("pobi", "woni", "jun");
    }

    //Todo : movecars() 메서드 테스트 함수 구현 필요.
    @Test
    void 차량_전진_메서드_테스트() {
        NumberGenerator alwaysForward = () -> MOVING_FORWARD;
        carService = new CarService(alwaysForward);

        List<Car> cars = carService.createCars(new String[]{"pobi"});
        carService.moveCars(cars);

        assertThat(cars.getFirst().getPresentLocation()).isEqualTo(1);
    }

    @Test
    void 차량_정지_메서드_테스트() {
        NumberGenerator alwaysStop = () -> STOP;
        carService = new CarService(alwaysStop);

        List<Car> cars = carService.createCars(new String[]{"pobi"});
        carService.moveCars(cars);

        assertThat(cars.getFirst().getPresentLocation()).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
