package racingcar;

import java.util.Scanner;

public class IOManager {
    static public void carInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();

        input = input.trim();
        inputCheck(input);

        scanner.close();
    }

    static private void inputCheck(String input) {

    }

    static private void printState() {

    }

    static private void printResult() {

    }
}
