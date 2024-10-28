package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String getStringInput() {
        return Console.readLine();
    }

    public int getIntegerInput() {
        return Integer.parseInt(Console.readLine());
    }
}
