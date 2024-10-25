package racingcar;

import static racingcar.Input.InputString.inputString;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println(inputString(input));
    }


}
