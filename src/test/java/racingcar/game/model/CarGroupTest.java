package racingcar.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.game.constant.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.game.constant.ExceptionMessage.INVALID_CAR_COUNT;

class CarGroupTest {
    private final CarGroup carGroup = new CarGroup();

    @Test
    @DisplayName("자동차 이름 리스트 추가 성공 케이스")
    void addCars_ValidInput() {
        //given
        List<String> carNames = List.of("car1", "car2", "car3");

        //when
        carGroup.addCars(carNames);

        //then
        List<Car> addedCars = carGroup.getCars();
        List<String> addedCarNames = addedCars.stream()
                .map(Car::getName)
                .toList();
        assertEquals(carNames, addedCarNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car2", "car1,car1"})
    @DisplayName("자동차 이름 중복 예외 케이스")
    void addCars_DuplicateCarName(String names) {
        //given
        List<String> carNames = Arrays.asList(names.split(","));
        //when & then
        assertThatThrownBy(() -> carGroup.addCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 개수 초과 예외 케이스")
    void addCars_MoreThan10() {
        //given
        List<String> carNames = List.of("pobi","jun","woni","yeonjoo","soeun","somin","chaeyoung","chaerin","seohyun","jinho","seongjin");

        assertThatThrownBy(() -> carGroup.addCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CAR_COUNT.getMessage());
    }
}