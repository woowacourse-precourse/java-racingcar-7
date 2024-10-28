package racingcar;

import java.util.ArrayList;
import racingcar.car.Car;

public class RacingService {
    private static final int START_INT = 0;
    private static final int END_INT = 9;

    private ArrayList<Car> carList;
    private int attemptCount;

    public RacingService(ArrayList<Car> carList, int attemptCount) {
        this.carList = carList;
        this.attemptCount = attemptCount;
    }

    public boolean checkForwardMovable() {
        int randomValue = generateRandomForwardValue();
        return randomValue >= 4;
    }

    public void raceOnce() {
        for (Car car : carList) {
            boolean isMoveForward = checkForwardMovable();
            car.forward(isMoveForward);
            car.showDistanceOutput();
        }
    }

    public void raceAll() {
        for (int i = 0; i < attemptCount; i++) {
            raceOnce();
            if (i != attemptCount - 1) {
                System.out.println();
            }
        }
    }

    public ArrayList<String> getWinner() {
        int maxDistance = getMaximumDistance();
        ArrayList<String> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public void showWinner() {
        ArrayList<String> winners = getWinner();
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    private int getMaximumDistance() {
        int maximumDistance = 0;
        for (Car car : carList) {
            if (car.getDistance() > maximumDistance) {
                maximumDistance = car.getDistance();
            }
        }
        return maximumDistance;
    }

    public int generateRandomForwardValue() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(START_INT, END_INT);
    }
}
