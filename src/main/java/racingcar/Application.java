package racingcar;

import controller.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        try {
            raceController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
