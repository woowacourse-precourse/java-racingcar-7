package racingcar.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import setup.TestCar;
import setup.TestCarList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CarListTest {

    private CarList testCarList;
    private static final String carName = "테스트카";
    private static final int size = 5;

    @BeforeEach
    void setUp() {
        List<Car> cars = IntStream.range(0, size)
                .mapToObj(i -> TestCar.getTestCar(carName + i))
                .collect(Collectors.toList());
        testCarList = TestCarList.getTestCarList(cars);
    }

    @Test
    @DisplayName("getCarList()메서드는 불변 객체가 반환되어야 한다.")
    void getCarList() {
        //when
        this.testCarList.add(TestCar.getTestCar(carName));
        List<Car> returnedCarList = testCarList.getCarList();

        //then
        Assertions.assertThat(this.testCarList.getCarList().size()).isEqualTo(size + 1);
        Assertions.assertThatThrownBy(() -> returnedCarList.add(TestCar.getTestCar(carName)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("가장 멀리 간 자동차의 거리를 반환해야 한다.")
    void getFurthestPosition() {
        //given
        List<Car> carList = testCarList.getCarList();

        //when
        IntStream.range(0, carList.size())
                .forEachOrdered(i -> {
                    Car car = carList.get(i);
                    IntStream.range(i, size)
                            .forEach(j -> car.move());
                });

        //then
        Assertions.assertThat(testCarList.getFurthestPosition())
                .isEqualTo(size);
    }
}