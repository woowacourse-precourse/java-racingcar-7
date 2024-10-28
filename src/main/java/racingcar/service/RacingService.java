package racingcar.service;

import racingcar.model.Car;
import racingcar.view.RacingView;

public class RacingService {
    private static Car[] carList;

    public static void setupRacing(String cars, String moveCount) {
        String[] racingCars = cars.split(",");
        carList = new Car[racingCars.length];
        int count = 0;
        for (String carName : racingCars) {
            if (!carName.isEmpty()) {
                carName = carName.trim();
                carList[count] = new Car(carName, moveCount);
                count++;
            }
        }
    }

    public static void startRacing() {
        System.out.println("실행 결과");
        int count = Integer.parseInt(carList[0].getMoveCount());
        for (int i = 0; i < count; i++) {
            trymove();
            RacingView.tryResult(getCars());
            System.out.println();
        }
    }

    private static Car[] getCars() {
        return carList;
    }

    private static void trymove() {
        for (Car car : carList) {
            car.tryMoving();
        }
    }

    public static void racingResult() {
        Car[] winners = new Car[carList.length];
        int maxMoving = 0;
        int winnerCount = 0;
        for (Car car : carList) {
            if (maxMoving < car.getMoving()) {
                winnerCount = 0;
                winners[winnerCount++] = car;
                maxMoving = car.getMoving();
            } else if (car.getMoving() == maxMoving) {
                winners[winnerCount++] = car;
            }
        }
        RacingView.racingResult(winners, winnerCount);
    }
}