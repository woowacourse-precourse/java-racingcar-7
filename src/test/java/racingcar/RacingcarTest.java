package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.*;

class RacingcarTest {

    private List<Car> cars;
    private Set<String> carNames;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        carNames = new HashSet<>();
    }

    @Test
    void duplicateCarName() {

        String[] carList = {"pobi", "woni", "woni"};

        assertThatThrownBy(() -> Application.makeCarsList(carList, cars, carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void carNameExceedsLengthLimit() {

        String[] carList = {"pobi", "woni", "junjun"};

        assertThatThrownBy(() -> Application.makeCarsList(carList, cars, carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void emptyCarName() {

        String[] carList = {"pobi", " "};

        assertThatThrownBy(() -> Application.makeCarsList(carList, cars, carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

}