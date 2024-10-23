package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Racing racing = new Racing();
    }
}

class Racing {

    InputString inputString;

    Racing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        inputString = new InputString(str);
    }
}

class InputString {

    private String inputString;

    InputString(String string) {
        if(string == null || string.isEmpty())
            throw new IllegalArgumentException();
        inputString = string;
    }

    public String getInputString() {
        return inputString;
    }


}
