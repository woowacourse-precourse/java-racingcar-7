package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi", 0);
    }

    @Test
    void 자동차_이름_조회_테스트() {

        // given
        String expectedName = "pobi";

        // when
        String carName = car.getCarName();

        // then
        assertEquals(expectedName, carName);

    }

    @Test
    void 자동차_이동거리_추가_테스트() {

        // given
        int addDistance = 5;
        int expectedDistance = 5;

        // when
        car.addDistance(addDistance);

        // then
        assertEquals(expectedDistance, car.getDistance());

    }

    @Test
    void 이동거리_누적_추가_테스트() {

        // given
        car.addDistance(3);
        car.addDistance(4);
        int expectedDistance = 7;

        // when
        int distance = car.getDistance();

        // then
        assertEquals(expectedDistance, distance);

    }
}
