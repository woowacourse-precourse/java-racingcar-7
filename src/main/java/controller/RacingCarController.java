package controller;

import view.RacingCarView;

public class RacingCarController {

    public void run() {
        RacingCarView racingCarView = new RacingCarView();
        String cars = racingCarView.readCars();
    }
}
