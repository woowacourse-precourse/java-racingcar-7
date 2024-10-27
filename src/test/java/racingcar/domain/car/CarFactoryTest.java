package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.CarDuplicateException;

class CarFactoryTest {

    @DisplayName("자동차를 생성하고 등록하는데 성공하는 테스트")
    @Test
    void registerCarTest() {
        CarFactory carFactory = new CarFactory();
        List<String> carNames = List.of("honda", "bmw", "benz", "ford");
        Cars cars = carFactory.makeCars(carNames);

        assertThat(cars.getCars().size()).isEqualTo(4);
        for(int i = 0; i < carNames.size(); i++) {
            assertThat(cars.getCars().get(i).getCarName()).isEqualTo(carNames.get(i));
        }
    }

    @DisplayName("중복된 자동차를 등록 시 예외를 발생하는 테스트")
    @Test
    void carRegisterFailTest() {
        CarFactory carFactory = new CarFactory();
        List<String> carNames = List.of("honda", "honda");
        assertThatThrownBy(() -> carFactory.makeCars(carNames))
                .isInstanceOf(CarDuplicateException.class);
    }
}
