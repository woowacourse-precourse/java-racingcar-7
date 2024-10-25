package racingcar.model;

import java.util.ArrayList;

public class RacingCarList {
    private ArrayList<RacingCar> racingCarList = new ArrayList<>();

    public void add(RacingCar racingCar) {
        racingCarList.add(racingCar);
    }

    public ArrayList<RacingCar> get() {
        return racingCarList;
    }
}
