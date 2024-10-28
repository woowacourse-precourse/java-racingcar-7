package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = InputView.getCarNames();
        int tryCount = InputView.getTryCount();
        RacingGame game = new RacingGame(cars, tryCount);

        System.out.println("실행 결과");
        game.play();
        OutputView.printWinners(game.getWinners());
    }
}