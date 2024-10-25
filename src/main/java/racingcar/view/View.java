package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String input() {
        return Console.readLine();
    }

    public String playerInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input();
    }

    public String roundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return input();
    }
}
