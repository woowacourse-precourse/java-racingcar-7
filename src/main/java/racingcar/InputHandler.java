package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private final ConsoleReader consoleReader;

    public InputHandler(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesString = consoleReader.readLine();
        String[] carNames = carNamesString.split(",");
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int inputMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String moveCountStr = consoleReader.readLine();
        int moveCount = Integer.parseInt(moveCountStr);
        InputValidator.validateMoveCount(moveCount);
        return moveCount;
    }
}
