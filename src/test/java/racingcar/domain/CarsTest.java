package racingcar.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 리스트 생성")
    void create_car_list_test() {
        Cars cars = Cars.from(carNames);
        assertEquals(cars.getCars().size(), carNames.size());
    }

    @Test
    @DisplayName("최대 위치값 구하기")
    void max_position_test() {
        Cars cars = Cars.from(carNames);
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);

        Position maxPosition = cars.maxPosition();
        Position moved = Position.create().move().move();

        assertEquals(maxPosition, moved);
    }

    @Test
    @DisplayName("우승자 이름 가져오기")
    void winner_name_test() {
        Cars cars = Cars.from(carNames);
        Car firstCar = cars.getCars().getFirst();
        firstCar.move(() -> true);
        firstCar.move(() -> true);
        cars.getCars().get(1).move(() -> true);

        List<Name> winnerNames = cars.getWinnerNames(cars.maxPosition());

        assertEquals(winnerNames.getFirst(), firstCar.getName());
    }
}