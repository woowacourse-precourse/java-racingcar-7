package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingGame;
import racingcar.model.Racingcar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingcarControllerTest {

    @Test
    void createRacingcars() {
        RacingcarController racingcarController = new RacingcarController();
//        List<Racingcar> racingcars = racingcarController.createRacingcars("car01,car02,car03");
//        for(Racingcar racingcar : racingcars) {
//            System.out.println(racingcar.getCarName());
//        }



    }

    @Test
    void runGame() {
        Racingcar car01=new Racingcar("car01");
        Racingcar car02=new Racingcar("car02");
        List<Racingcar> cars=new ArrayList<>();
        cars.add(car01);
        cars.add(car02);
        int moveCount=3;

        RacingGame racingGame = new RacingGame(cars, moveCount);
        RacingcarController racingcarController = new RacingcarController();
        racingcarController.RunGame(racingGame, cars, moveCount);

    }
}