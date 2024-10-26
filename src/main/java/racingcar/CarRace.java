package racingcar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CarRace {
    private static final int CAR_NAME_LENGTH_MAX = 5;
    private ArrayList<RacingCar> participants = new ArrayList<>();
    private ArrayList<RacingCar> winners = new ArrayList<>();
    private Set<String> participantNames = new HashSet<>();
    private int numRounds;
    private int currentRound;

    private void simulateRound() {
        /* 레이스 종료시 진행 금지 */
        if (currentRound >= numRounds) {
            return ;
        }
        for (RacingCar car : participants) {
            car.simulateRound();
        }
        currentRound++;
    }

    /**
     *
     * @return 마지막 라운드까지 진행완료시 참, else 거짓
     */
    public boolean isRaceFinished() {
        return (currentRound == numRounds);
    }

    private int getHeadDistance() {
        int headDistance = 0;

        for (RacingCar car : participants) {
            if (car.getTraveledDistance() > headDistance) {
                headDistance = car.getTraveledDistance();
            }
        }
        return headDistance;
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
     * 경주의 우승자들을 winners ArrayList 에 추가하는 프로시져
     */
    public void processRaceWinners() {
        if (!isRaceFinished()) {
            return ;
        }

        int winnerDistance = getHeadDistance();
        for (RacingCar car : participants) {
            if (car.getTraveledDistance() == winnerDistance) {
                winners.add(car);
            }
        }
    }

    /**
     * 레이싱 경주를 시작하는 프로시져 함수
     *
     * @throws IOException
     */
    public void run() throws IOException {
        RaceDisplay.displayStart();
        while (!isRaceFinished()) {
            simulateRound();
            RaceDisplay.displayCurrentState(this);
        }
        processRaceWinners();
        RaceDisplay.displayWinner(this);
        RaceDisplay.close();
    }

    public void setNumRounds(int numRound) {
        /* int 범위 초과 or 문자열 포함 */
        if (!NumberUtil.isPositive(numRound) || numRound > 1000) {
            throw new IllegalArgumentException();
        }
        this.numRounds = numRound;
    }

    public Set<String> getParticipantNames() {
        return participantNames;
    }

    public ArrayList<RacingCar> getParticipants() {
        return participants;
    }

    public ArrayList<RacingCar> getWinners() {
        return winners;
    }

    public CarRace() {
        numRounds = 0;
        currentRound = 0;
    }
}
