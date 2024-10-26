package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("dong", "teco");
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("여러 자동차 생성에 성공한다.")
    void createCars() {
        //when
        List<String> createdCarNames = cars.getCarNames();

        //then
        assertThat(createdCarNames).containsExactly("dong", "teco");
    }
}
