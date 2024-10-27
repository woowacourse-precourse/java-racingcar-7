package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GeneralCarFactoryTest {

    @Test
    @DisplayName("자동차 생성 테스트 - 성공1")
    void createCarTestSuccess1() throws Exception {
        //given
        CarFactory carFactory = GeneralCarFactory.getInstance();
        List<String> carList = List.of("He1", "EH2", "CarNm");

        //when
        List<Car> cars = carFactory.createCars(carList);

        //then
        Assertions.assertThat(cars).hasSize(3)
                .extracting(Car::getName)
                .isEqualTo(carList);
    }

    @Test
    @DisplayName("자동차 생성 테스트 - 성공2")
    void createCarTestSuccess2() throws Exception {
        //given
        CarFactory carFactory = GeneralCarFactory.getInstance();
        List<String> carList = List.of("car1 ", " car2");

        //when
        List<Car> cars = carFactory.createCars(carList);

        //then
        Assertions.assertThat(cars).hasSize(2)
                .extracting(Car::getName)
                .isEqualTo(carList);
    }

    @Test
    @DisplayName("자동차 생성 테스트 - 실패1")
    void createCarTestFail1() throws Exception {
        //given
        CarFactory carFactory = GeneralCarFactory.getInstance();
        List<String> carList = List.of("He1", " ", "CarName");

        //when & then
        Assertions.assertThatThrownBy(() -> carFactory.createCars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백으로만 이루어져 있습니다.");

    }

    @Test
    @DisplayName("자동차 생성 테스트 - 실패2")
    void createCarTestFail2() throws Exception {
        //given
        CarFactory carFactory = GeneralCarFactory.getInstance();
        List<String> carList = List.of(" ", " ", " ");

        //when & then
        Assertions.assertThatThrownBy(() -> carFactory.createCars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백으로만 이루어져 있습니다.");

    }

    @Test
    @DisplayName("자동차 생성 테스트 - 실패3")
    void createCarTestFail3() throws Exception {
        //given
        CarFactory carFactory = GeneralCarFactory.getInstance();
        List<String> carList = List.of("Hello", "MyCarName", "Hell");

        //when & then
        Assertions.assertThatThrownBy(() -> carFactory.createCars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이가 5초과 합니다.");

    }
}