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
        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
            }
        }
    }

    static private void printState() {

    }

    static private void printResult() {

    }
}
