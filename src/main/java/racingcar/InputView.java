package racingcar;

import java.util.List;

public class InputView {

    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<String> requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return inputHandler.inputCarName();
    }

    public int requestAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return inputHandler.inputAttemptNumber();
    }
}
