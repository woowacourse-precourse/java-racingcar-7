package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private Boolean isFinished = false;

    private List<Car> participants;
    private List<Car> winners;
    private int attempts;

    public CarGame() {
        this.participants = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void updateAttempts(int attempts) {
        this.attempts = attempts;
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

}
