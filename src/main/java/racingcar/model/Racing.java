package racingcar.model;

import java.util.List;

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
        participants.moveCarsRandomly();
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

    public static Racing from(List<String> carNames, int totalRounds) {
        Participants participants = Participants.from(carNames);
        return new Racing(participants, totalRounds);
    }
}
