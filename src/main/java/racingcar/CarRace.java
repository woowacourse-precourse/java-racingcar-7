package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CarRace {
    private static final int CAR_NAME_LENGTH_MAX = 5;
    private ArrayList<RacingCar> participants = new ArrayList<>();
    private Set<String> participantNames = new HashSet<>();
    private int numRounds;
    private int currentRound;

    private void simulateRound() {
        for (RacingCar car : participants) {
            car.simulateRound();
        }
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

    /**
     * CarRace 에 참가하는 차를 추가
     *
     * @param carName
     * @throws DuplicateCarNameException
     */
    public void addParticipants(String carName)
            throws DuplicateCarNameException {
        if (carName.length() > CAR_NAME_LENGTH_MAX || participantNames.contains(carName)) {
            throw new DuplicateCarNameException(carName);
        }
        participantNames.add(carName);

        RacingCar car = new RacingCar(carName);
        participants.add(car);
    }

    /**
     * 레이싱 경주를 시작하는 프로시져 함수
     *
     * @throws IOException
     */
    public void run() throws IOException {
        while (currentRound < numRounds) {
            simulateRound();
            RaceDisplay.displayCurrentState(this);
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

    public Set<String> getParticipantNames() {
        return participantNames;
    }

    public ArrayList<RacingCar> getParticipants() {
        return participants;
    }

}
