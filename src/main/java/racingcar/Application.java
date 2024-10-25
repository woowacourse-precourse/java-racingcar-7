package racingcar;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        view.printCarNamePrompt();
        String inputCarNames = view.readInput();
        Validator validator = new Validator();
        String[] carNames = validator.validateCarNames(inputCarNames);

        view.printCountPrompt();
        String inputCount = view.readInput();
        int count = validator.validateCount(inputCount);

        view.printResultPrompt();

        Game game = new Game(carNames);

        for (int i = 0; i < count; i++) {
            Map<String, StringBuilder> roundResult = game.moveCarsIfQualified();
            view.printStatus(roundResult);
            System.out.println();
        }

        List<String> winners = game.getWinners();
        view.printWinners(winners);
    }
}
