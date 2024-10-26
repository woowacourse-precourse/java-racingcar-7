package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingManagerTest {
    private RacingManager racingManager;
    @BeforeEach
    void setUp(){
        racingManager = new RacingManager();
    }

    @Test
    void 자동차_이름을_객체로_변환(){
        String carNames = "a,bb,ccc";
        List<Car>carList = racingManager.parseCarNamesToCar(carNames);

        assertThat(carList).hasSize(3);
        assertThat(carList).extracting(Car::getName)
                .containsExactly("a", "bb", "ccc");
    }

    @Test
    void 공백이_포함된_자동차_이름을_객체로_변환(){
        String carNames = "a, bb , ccc";
        List<Car>carList = racingManager.parseCarNamesToCar(carNames);

        assertThat(carList).hasSize(3);
        assertThat(carList).extracting(Car::getName)
                .containsExactly("a", "bb", "ccc");
    }
}