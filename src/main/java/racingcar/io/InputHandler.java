package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();
        return getCarNamesArray(inputString);
    }

    private String[] getCarNamesArray(String inputString) {
        return inputString.split(",");
    }

    public int getTryNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String tryNum = Console.readLine();
        return Integer.parseInt(tryNum);
    }
}
