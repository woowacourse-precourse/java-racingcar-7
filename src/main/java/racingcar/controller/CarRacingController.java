package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {

    public ArrayList<String> divide(String cars) {
        return new ArrayList<>(List.of(cars.split(",")));
    }
}
