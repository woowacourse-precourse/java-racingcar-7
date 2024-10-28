package racingcar.service.factory;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.member.Member;

class CarFactoryTest {

    private List<String> nameList;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        nameList = List.of("A", "B", "C");
        carList = List.of(Car.of(new Member("A")), Car.of(new Member("B")), Car.of(new Member("C")));
    }

    @Test
    @DisplayName("name list를 바탕으로 car list를 만들어 반환한다.")
    void name_list를_받아서_car_list를_반환하는_테스트() {
        CarFactory carFactory = new CarFactory();
        List<Car> carListByFactory = carFactory.getCarList(nameList);

        Assertions.assertThat(carListByFactory).hasSize(nameList.size())
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(carList);
    }
}