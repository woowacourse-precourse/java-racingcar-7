package racingcar.model;

import java.util.ArrayList;

public class RacingCarList {

    private static ArrayList<RacingCar> racingCarList = new ArrayList<>();

    public void add(RacingCar racingCar) {
        racingCarList.add(racingCar);
    }

    public static ArrayList<RacingCar> get() {
        return racingCarList;
    }
}
