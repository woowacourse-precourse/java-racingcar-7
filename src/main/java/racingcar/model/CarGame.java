package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private List<Car> participants;
    private List<Car> winners;
    private int maxDistance;

    public CarGame() {
        this.participants = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.maxDistance = 0;
    }

    public void updateMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    public void addWinner(Car car) {
        this.winners.add(car);
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public int getMaxDistance() {
        return maxDistance;
    }
}
