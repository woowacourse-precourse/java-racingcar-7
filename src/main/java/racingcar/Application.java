package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();

        List<String> carList = Arrays.asList(input.inputCarNames().split(","));
        Cars cars = new Cars(carList);

        int attempt = input.inputAttempt();

        Game game = new Game(cars);

        System.out.println("\n실행 결과");
        for (int i = 0; i < attempt; i++) {
            game.play();
        }

        Output.printWinner(cars.findWinner());
    }
}