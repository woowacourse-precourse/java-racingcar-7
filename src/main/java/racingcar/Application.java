package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<String> carNames = inputHandler.getNames(inputNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        int count = Integer.parseInt(inputCount);
        System.out.println();

        GameLogic gameLogic = new GameLogic(carNames, count);
        System.out.println("실행 결과");
        gameLogic.race();
        gameLogic.finalResults();
    }
}
