package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int rounds = InputView.inputRounds();

        System.out.println();
        System.out.println("실행 결과");

        Race race = new Race(carNames, rounds);
        race.start();
        List<String> winners = race.getWinners();
        ResultView.printWinners(winners);
    }
}
