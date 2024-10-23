package racingcar;

import view.ConsoleView;

public class Application {
    public static void main(String[] args) {

        // 1. 입력 & 2. 구분
        ConsoleView consoleView = new ConsoleView();
        String[] carNames = consoleView.getCarNames();
        int moveCount = consoleView.getMoveCount();

        // TODO: 입력 구조 점검 및 다음 기능들 구현
    }
}
