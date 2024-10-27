package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {

    }

    public String[] inputCarNameGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return seperatePlayers(Console.readLine());
    }

    public String[] seperatePlayers(String players) {
        return players.split(",");
    }

    public int inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

}
