package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    private final CarFactory carFactory = CarFactory.getInstance();

    @Test
    void CarFactory_생성() {
        assertThat(carFactory).isEqualTo(CarFactory.getInstance());
    }

    @Test
    void Cars_생성() {
        String carNames = "pobi,nana";
        List<Car> carList = List.of(new Car("pobi"), new Car("nana"));
        assertThat(carFactory.createCars(carNames)).isEqualTo(new Cars(carList));
    }

    @Test
    void 자동차_이름_공백_제거하여_Cars_생성() {
        String carNames = " pobi  , nana  ,   jun  ";
        List<Car> carList = List.of(new Car("pobi"), new Car("nana"), new Car("jun"));
        assertThat(carFactory.createCars(carNames)).isEqualTo(new Cars(carList));
    }

    @Test
    void 콤마로_split_할_수_없음() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carFactory.createCars("pobi:nana,jun"))
                .withMessageMatching("자동차 이름은 콤마로 구분해야 합니다");
    }
}
