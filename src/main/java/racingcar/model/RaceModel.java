package racingcar.model;

import java.util.List;

public class RaceModel {

    private static RaceModel raceModel;
    private List<String> players;
    private List<Integer> progress;
    private List<String> winners;
    private int raceCount;

    private RaceModel() {
    }

    public static RaceModel getInstance() {
        if (raceModel == null) {
            raceModel = new RaceModel();
        }
        return raceModel;
    }

    public List<String> getPlayers() {
        return players;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public List<Integer> getProgress() {
        return progress;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public void setProgress(List<Integer> progress) {
        this.progress = progress;
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }
}
