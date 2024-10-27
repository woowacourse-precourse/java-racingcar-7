package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void Message() {
        System.out.println("자동차 대수는 몇 대 인가요?(쉼표(,)를 기준으로 구분)");
    }

    public String userInput() {
        return Console.readLine();
    }
}
