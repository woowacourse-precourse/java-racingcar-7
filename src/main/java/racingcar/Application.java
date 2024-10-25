package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
