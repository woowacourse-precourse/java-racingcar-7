//Application.java 
package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int rounds = InputView.inputRounds();

        Race race = new Race(carNames, rounds);
        System.out.println("실행 결과");

        race.start();
        List<String> winners = race.getWinners();
        ResultView.printWinners(winners);
    }
}
