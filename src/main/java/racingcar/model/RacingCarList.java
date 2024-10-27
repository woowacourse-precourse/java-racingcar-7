package racingcar.model;

import java.util.ArrayList;

public class RacingCarList {

    private static final ArrayList<RacingCar> racingCarList = new ArrayList<>();

    private RacingCarList() {}

    public static void add(RacingCar racingCar) {
        racingCarList.add(racingCar);
    }

    public static ArrayList<RacingCar> get() {
        return racingCarList;
    }
}
