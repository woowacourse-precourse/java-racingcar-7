package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 0. 클래스 초기화
        CommaCarNameTokenizer commaCarNameTokenizer = new CommaCarNameTokenizer();
        CarFactory carFactory = new CarFactory(commaCarNameTokenizer);
        MoveCondition moveCondition = new RandomMoveCondition();

        CarGameManager carGameManager = new CarGameManager(carFactory, moveCondition);

        // 1. 게임 시작
        carGameManager.startGame();

        Console.close();
    }
}
