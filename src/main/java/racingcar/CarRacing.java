package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final int attempt;
    private final CarGroup carGroup;

    CarRacing(CarGroup carGroup, int attempt) {
        this.carGroup = carGroup;
        this.attempt = attempt;
    }

    public int getAttempt() {
        return attempt;
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }

    private List<String> getCarRacingRecords() {
        List<String> carRacingRecords = new ArrayList<>();

        for (int i = 0; i < attempt; i++) {
            carGroup.accelerateAll();
            carRacingRecords.add(carGroup.getDrivingRecords());
        }
        return carRacingRecords;
    }

    private String getCarRacingResult() {
        CarRacingWinner winner = new CarRacingWinner(carGroup);
        return winner.getWinners();
    }

    public List<String> race() {
        List<String> raceResult = new ArrayList<>();
        raceResult.addAll(getCarRacingRecords());
        raceResult.add(getCarRacingResult());
        return raceResult;
    }
}
