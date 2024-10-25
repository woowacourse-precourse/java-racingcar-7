package racingcar.model;

import java.util.List;

public class RaceModel {

    private static RaceModel raceModel;
    private List<String> winners;
    private List<Car> cars;
    private int raceCount;

    private RaceModel() {
    }

    public static RaceModel getInstance() {
        if (raceModel == null) {
            raceModel = new RaceModel();
        }
        return raceModel;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }
}
