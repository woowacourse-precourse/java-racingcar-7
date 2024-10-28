package racingcar;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int moveCount;
    private final WinnerManager winnerManager;

    public RacingGame(List<Car> cars, int moveCount, WinnerManager winnerManager) {
        this.cars = cars;
        this.moveCount = moveCount;
        this.winnerManager = winnerManager;
    }

    void playTurn() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getStatus());
        }
    }

    void playGame() {
        for (int i = 0; i < moveCount; i++) {
            playTurn();
            System.out.println();
        }
    }

    void announceWinners() {
        List<Car> winners = winnerManager.determineWinners(cars);
        System.out.println("최종 우승자 : " + winnerManager.getWinnerNames(winners));
    }
}
