package racingcar.model.racing;

import java.util.List;
import racingcar.model.car.Car;

public class Racing {
    private final Participants participants;
    private final int totalRounds;
    private int currentRound;

    private Racing(Participants participants, int totalRounds) {
        this.participants = participants;
        this.totalRounds = totalRounds;
        this.currentRound = 0;
    }


    public void executeRound() {
        participants.moveCars();
        currentRound++;
    }

    public Participants getParticipants() {
        return participants;
    }

    public boolean hasNextRound() {
        return (currentRound < totalRounds);
    }

    public List<Car> getWinners() {
        int maxDistance = participants.getMaxMovedDistance();
        return participants
                .findCarsWithMovedDistance(maxDistance);
    }

    public static Racing from(List<Car> cars, int totalRounds) {
        Participants participants = new Participants(cars);
        return new Racing(participants, totalRounds);
    }
}
