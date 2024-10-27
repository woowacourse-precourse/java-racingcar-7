package racingcar;

import racingcar.io.CarInputHandler;
import racingcar.race.track.cartrack.CarRacetrack;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarInputHandler inputHandler = new CarInputHandler();

        String[] names = inputHandler.inputRacerNames();
        int repeat = inputHandler.inputRepeatNum();

        CarRacetrack carRacetrack = new CarRacetrack(names, repeat);
        carRacetrack.raceStart();
    }
}
