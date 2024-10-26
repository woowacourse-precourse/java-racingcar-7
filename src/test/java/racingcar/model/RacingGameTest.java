package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void moveRacingcars() {
        Racingcar car01 = new Racingcar("pobi");
        Racingcar car02 = new Racingcar("woni");

        List<Racingcar> cars = new ArrayList<>();
        cars.add(car01);
        cars.add(car02);

        RacingGame racingGame = new RacingGame(cars, 3);
        racingGame.MoveRacingcars();


        assertTrue(car01.getLocation() >= 0 && car01.getLocation() <= 1);
        assertTrue(car02.getLocation() >= 0 && car02.getLocation() <= 1);

        System.out.println("car01.getLocation() = " + car01.getLocation());
        System.out.println("car02.getLocation() = " + car02.getLocation());
    }

    @Test
    void getCarsLocation() {
    }
}