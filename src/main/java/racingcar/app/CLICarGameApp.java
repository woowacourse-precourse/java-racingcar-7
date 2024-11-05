package racingcar.app;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.CarGame;
import racingcar.GameConfigParser;
import racingcar.GameFactory;

public class CLICarGameApp implements CarGameApp {
    public void showInputCarNameDialogue() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void showInputNumberOfTurnDialogue() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public void showExecutionResultInit() {
        System.out.println("\n실행 결과");
    }
    public List<String> getCarNames() {
        String input = Console.readLine();
        return GameConfigParser.parseCarNames(input);
    }

    public int getNumberOfTurn() {
        String input = Console.readLine();
        return GameConfigParser.parseNumberOfTurn(input);
    }

    @Override
    public CarGame initCarGame() {
        showInputCarNameDialogue();
        List<String> carNames = getCarNames();
        showInputNumberOfTurnDialogue();
        int numberOfTurn = getNumberOfTurn();
        showExecutionResultInit();
        return GameFactory.of(carNames, numberOfTurn);
    }
}
