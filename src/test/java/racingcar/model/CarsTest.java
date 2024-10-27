package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

public class CarsTest {
    private final static String NAMES = "hana,min,aria";
    private final static int COUNT = 3;

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    public void 자동차_추가() {
        Arrays.stream(NAMES.split(Constants.COMMA))
                .forEach(name -> cars.addCar(name));

        assertThat(cars.getRaceInfos().size())
                .isEqualTo(COUNT);
    }

    @Test
    public void 우승자_확인() {
        Arrays.stream(NAMES.split(Constants.COMMA))
                .forEach(name -> cars.addCar(name));

        cars.raceCars();
        cars.raceCars();

        assertThat(cars.getRaceWinner())
                .isNotBlank();
    }
}