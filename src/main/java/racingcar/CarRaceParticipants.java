package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRaceParticipants {

    private static final CarRaceParticipants INSTANCE = new CarRaceParticipants();
    private final List<RacingCar> RACING_CARS = new ArrayList<>();

    private CarRaceParticipants() {

    }

    public static CarRaceParticipants getInstance() {
        return INSTANCE;
    }

    public void addAll(List<RacingCar> racingCars) {
        RACING_CARS.addAll(racingCars);
    }
}
