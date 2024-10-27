package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1.1 경주할 자동차 목록을 입력받는 기능
        String carNamesInputString = getCarNamesInputString();
        // 1.2 경주할 자동차 목록을 쉼표(,)를 기준으로 구분하는 기능
        String[] carNames = getCarNames(carNamesInputString);
    }

    public static String getCarNamesInputString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String[] getCarNames(String carNamesInputString) {
        return carNamesInputString.split(",");
    }

}
