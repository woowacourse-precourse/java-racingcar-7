package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constants.Constants;

public class CarFactoryTest {

    private CarFactory carFactory;
    private final Car CAR_POBI = new Car("pobi");
    private final Car CAR_NANA = new Car("nana");
    private final Car CAR_JUN = new Car("jun");

    @BeforeEach
    void setUp() {
        carFactory = CarFactory.getInstance();
    }

    @Test
    void CarFactory_생성() {
        assertThat(carFactory).isEqualTo(CarFactory.getInstance());
    }

    @Test
    void Cars_생성() {
        String names = "pobi,nana";
        List<Car> carList = List.of(CAR_POBI, CAR_NANA);

        assertThat(carFactory.createCars(names)).isEqualTo(new Cars(carList));
    }

    @Test
    void 자동차_이름_공백_제거하여_Cars_생성() {
        String names = " pobi  , nana  ,   jun  ";
        List<Car> carList = List.of(CAR_POBI, CAR_NANA, CAR_JUN);
        
        assertThat(carFactory.createCars(names)).isEqualTo(new Cars(carList));
    }

    @Test
    void 콤마로_자동차_이름_split_못함() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carFactory.createCars("pobi:nana,jun"))
                .withMessageMatching(Constants.NOT_CAR_NAMES_DIVIDED_COMMA);
    }
}
