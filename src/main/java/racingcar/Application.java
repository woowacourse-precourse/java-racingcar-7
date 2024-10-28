package racingcar;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분):");
            String inputNames = scanner.nextLine();
            List<Car> cars = InputView.createCars(inputNames);

            System.out.println("시도할 횟수:");
            int rounds = Integer.parseInt(scanner.nextLine());

            RacingGame racingGame = new RacingGame(cars, rounds, new RandomMoveStrategy());
            racingGame.run(); // 각 라운드의 결과를 출력함
            ResultView.printWinners(racingGame.getWinners());
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}