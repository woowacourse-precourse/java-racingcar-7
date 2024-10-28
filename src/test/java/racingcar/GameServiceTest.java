package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.service.RandomNumberGenerator;

public class GameServiceTest extends NsTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final CarService carService = new CarService(randomNumberGenerator);
    private final GameService gameService = new GameService();

    @Test
    void 최대_거리_테스트() {
        List<Car> cars = carService.createCars(new String[]{"pobi", "woni", "jun"});
        for (int i = 0; i < 5; i++) {
            cars.getFirst().goForward();
        }
        assertThat(gameService.getMaxLocation(cars)).isEqualTo(5);
    }

    @Test
    void 우승자_선별_테스트() {
        List<Car> cars = carService.createCars(new String[]{"pobi", "woni", "jun"});
        for (int i = 0; i < 5; i++) {
            cars.getFirst().goForward();
        }

        assertThat(gameService.selectWinners(cars).getFirst()).isEqualTo((cars.getFirst()));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
