package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarServiceTest {

    private final Validator validator = new Validator();
    private final CarRepository carRepository = new CarRepository();

    @Test
    @DisplayName("입력을 콤마 기준으로 분할")
    void 입력테스트() {
        validator.checkCarName("pobi,woni,jun");
    }

    @Test
    @DisplayName("검증 후 carDB에 저장되는지 확인")
    void 저장테스트() {
        carRepository.save(new Car("pobi"));
        carRepository.save(new Car("woni"));
        carRepository.save(new Car("jun"));
        List<Car> carList = carRepository.findAll();

        assertThat(carList).hasSize(3); // 저장된 자동차의 개수를 검증
        assertThat(carList).extracting(Car::getName).contains("pobi", "woni", "jun"); // 이름 검증
    }

    @Test
    @DisplayName("공백입력 체크")
    void 공백입력시_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> validator.checkLastIndexCar("pobi,hf,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    @DisplayName("5자 이상 입력시 오류")
    void 이름이5자이상입력시_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> validator.checkCarName("qwertaq,ad,wed"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("이름 중복 테스트")
    void 이름중복시_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> validator.checkCarName("test,test,test1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 이름을 가진 자동차가 존재합니다.");
    }
}
