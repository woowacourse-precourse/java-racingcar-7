package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingCarTest {
    private Car car1;
    private Car car2;
    private Car car3;

    private RacingCar racingCars;

    @BeforeEach
    void setup() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");

        racingCars = new RacingCar(Arrays.asList(car1, car2, car3));
    }

    @DisplayName("자동차들이 이동했는지 확인")
    @Test
    void movingCars() {
        int initPosition1 = car1.getPosition();
        int initPosition2 = car2.getPosition();
        int initPosition3 = car3.getPosition();

        racingCars.moving();

        boolean anyMoved = (initPosition1 != car1.getPosition()) ||
                (initPosition2 != car2.getPosition()) || (initPosition3
                != car3.getPosition());

        assertTrue(anyMoved, "모든 자동차가 움직이지 않았습니다.");
    }


    @DisplayName("단일 우승자를 구하는 테스트")
    @Test
    void singleWinner() {
        car1.move(5);
        car1.move(4);
        car1.move(5);

        String winner = String.join("", racingCars.getWinner());
        assertEquals(car1.getName(), winner);
    }

    @DisplayName("우승자가 여러 명일 경우 우승자를 구하는 테스트")
    @Test
    void multipleWinner() {
        car1.move(5);
        car1.move(4);
        car1.move(5);
        car2.move(5);
        car2.move(4);
        car2.move(5);

        List<String> winners = racingCars.getWinner();
        assertEquals(Arrays.asList(car1.getName(), car2.getName()), winners);
    }
}