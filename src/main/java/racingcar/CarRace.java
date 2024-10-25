package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CarRace {
    private ArrayList<RacingCar> participants = new ArrayList<>();
    private Set<String> participantNames = new HashSet<>();
    private int numRounds;
    private int currentRound;

    public Set<String> getParticipantNames() {
        return participantNames;
    }

    public void addParticipants(String carName)
            throws DuplicateCarNameException {
        if (carName.length() > 5 || participantNames.contains(carName)) {
            throw new DuplicateCarNameException(carName);
        }
        participantNames.add(carName);

        RacingCar car = new RacingCar(carName);
        participants.add(car);
    }

    public static class DuplicateCarNameException extends Exception {
        private final String carName;

        public DuplicateCarNameException(String carName) {
            super("Duplicate car name: " + carName);
            this.carName = carName;
        }

        public String getCarName() {
            return carName;
        }
    }

    public void setNumRounds(int numRound) {
        /* int 범위 초과 or 문자열 포함 */
        if (!NumberUtil.isPositive(numRound)) {
            throw new IllegalArgumentException();
        }
        this.numRounds = numRound;
    }

    public CarRace() {
        numRounds = 0;
        currentRound = 0;
    }
}
