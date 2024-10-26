package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String playerNames = Console.readLine();

        return playerNames;
    }

    public int printRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?\n");
        int gameRounds = Integer.parseInt(Console.readLine());

        return gameRounds;
    }
}