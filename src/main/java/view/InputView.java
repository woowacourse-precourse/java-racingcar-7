package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import model.InputHandler;

public class InputView {

    private final InputHandler inputHandler = new InputHandler();

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = readLine();
        return inputHandler.splitCarNames(carNames);
    }

    public int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String moveCount = readLine();
        return inputHandler.toInt(moveCount);
    }

}
