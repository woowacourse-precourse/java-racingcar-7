package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.CarService;

class CarServiceTest extends NsTest {

    private final CarService carService = new CarService();

    @Test
    void 차량_생성_테스트() {
        List<Car> cars = carService.createCars(new String[]{"pobi", "woni", "jun"});
        assertThat(cars)
                .hasSize(3)
                .extracting("carName")
                .containsExactly("pobi", "woni", "jun");
    }

    //Todo : movecars() 메서드 테스트 함수 구현 필요.

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
