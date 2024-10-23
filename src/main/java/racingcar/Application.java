package racingcar;

import view.ConsoleView;

public class Application {
    public static void main(String[] args) {

        // 1. 입력
        ConsoleView consoleView = new ConsoleView();
        consoleView.getCarNames();
        consoleView.getMoveCount();

        // TODO: 입력 구조 정검 및 다음 기능들 구현
    }
}
