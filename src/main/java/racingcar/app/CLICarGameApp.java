package racingcar.app;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.CarGame;
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
        String names = Console.readLine();
        String [] splited = names.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : splited) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름으로 공백은 허용되지 않습니다.");
            }
            carNames.add(name);
        }
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("반드시 하나 이상의 자동차 이름이 필요합니다.");
        }
        return carNames;
    }

    public int getNumberOfTurn() {
        String number = Console.readLine().trim();
        int numberOfTurn = Integer.parseInt(number);
        if (numberOfTurn < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수여선 안됩니다.");
        }
        return numberOfTurn;
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
