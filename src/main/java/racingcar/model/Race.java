package racingcar.model;

import java.util.List;

public class Race {
    private List<Car> raceParticipants;
    private int rounds;

    public Race(List<Car> raceParticipants, int rounds) {
        this.raceParticipants = raceParticipants;
        this.rounds = rounds;
    }


}
