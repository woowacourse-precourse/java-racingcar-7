package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public boolean stopOrGo() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void printEachRound(List<Car> racingCar) {
        for (Car car : racingCar) {
            if (stopOrGo()) {
                car.advance += 1;
            }
            String statusBar = "-".repeat(car.advance);
            System.out.println(car.name + " : " + statusBar);
        }
        System.out.println();
    }

    public String decideWinner(List<Car> racingCar) {
        int maxValue = Integer.MIN_VALUE;
        ArrayList<String> winnerList = new ArrayList<>();

        for (Car car : racingCar) {
            if (car.advance > maxValue) {
                maxValue = car.advance;
                winnerList.clear();
                winnerList.add(car.name);
            } else if (car.advance == maxValue) {
                winnerList.add(car.name);
            }
        }
        return String.join(",", winnerList);
    }

    public void playGames(List<Car> racingCar, int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            printEachRound(racingCar);
        }
        System.out.println("최종 우승자 : " + decideWinner(racingCar));
    }

    public static void main(String[] args) throws IllegalArgumentException {
        Application application = new Application();
        InputHandler inputHandler = new InputHandler();

        application.playGames(inputHandler.getCarNames(), inputHandler.getNumberOfGames());
    }
}
