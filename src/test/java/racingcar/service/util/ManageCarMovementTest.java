package racingcar.service.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class ManageCarMovementTest {
    ManageCarMovement manageCarMovement;
    List<String> cars;

    @BeforeEach
    void beforeEach() {
        manageCarMovement = new ManageCarMovement();
        cars = new ArrayList<>(Arrays.asList("car1", "car2", "car3", "car4"));
    }

    @Test
    @DisplayName("manageCarMovement 객체가 잘 초기화 되는지 검증")
    void 초기화_기능_검증() {
        manageCarMovement.initialize(cars);
        Map<String, String> movementCount = manageCarMovement.getCarMovementCount();
        cars.forEach(s -> assertThat(movementCount.get(s)).isEqualTo(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3", "car4"})
    @DisplayName("manageCarMovement 객체가 잘 업데이트 되는지 검증")
    void 전진_횟수_업데이트_기능_검증(String carName) {
        manageCarMovement.initialize(cars);
        manageCarMovement.update(carName);
        Map<String, String> movementCount = manageCarMovement.getCarMovementCount();
        assertThat(movementCount.get(carName)).isEqualTo("-");
    }
}