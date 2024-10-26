package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Racingcar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingcarControllerTest {

    @Test
    void createRacingcars() {
        RacingcarController racingcarController = new RacingcarController();
        List<Racingcar> racingcars = racingcarController.createRacingcars("car01,car02,car03");
        for(Racingcar racingcar : racingcars) {
            System.out.println(racingcar.getCarName());
        }



    }
}