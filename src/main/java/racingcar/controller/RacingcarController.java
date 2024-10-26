package racingcar.controller;

import racingcar.model.Racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingcarController {




    public List<Racingcar> createRacingcars(String racingcarNames) {
        String[] racingcars = racingcarNames.split(",");
        List<Racingcar> racingcarsList = new ArrayList<>();

        for(String racingcarName : racingcars) {
            racingcarName = racingcarName.trim();
            if (racingcarName.length() > 5) {
                throw new IllegalArgumentException();
            }
            racingcarsList.add(new Racingcar(racingcarName));
        }
        return racingcarsList;
    }
}
