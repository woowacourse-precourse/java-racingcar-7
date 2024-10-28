package racingcar.model.racing;

import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.car.Car;

public class Racing {
    private static final int MAX_RACE_ROUND = 100;
    private static final int MIN_RACE_ROUND = 0;

    private final Participants participants;
    private final int totalRounds;
    private int currentRound;

    private Racing(Participants participants, int totalRounds) {
        validateRaceRoundInBound(totalRounds);
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

    private void validateRaceRoundInBound(int totalRounds) {
        if (totalRounds < MIN_RACE_ROUND || totalRounds > MAX_RACE_ROUND) {
            throw new RacingCarException(ErrorMessage.RACE_ROUND_OUT_OF_BOUND);
        }
    }
}
