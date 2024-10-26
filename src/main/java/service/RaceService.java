package service;

import model.Race;

import java.util.List;

public class RaceService {
    private final Race race;

    public RaceService(List<String> carNames, int attempts, MoveStrategy moveStrategy) {
        this.race = new Race(carNames, attempts, moveStrategy);
    }

    public void startRace(RaceStatusCallback callback) {
        race.startRace(callback);
    }

    public List<String> getWinners(){
        return race.getWinners();
    }
}
