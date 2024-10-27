package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputUser {

    public List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = List.of(Console.readLine().split(","));
        nameLengthValidation(names);
        return names;
    }

    public int inputNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String number = Console.readLine();
        isNumber(number);
        return Integer.parseInt(number);
    }

    private void nameLengthValidation(List<String> names) {
        for(String name : names) {
            if (5 < name.length()) {
                throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
            }
        }
    }

    private int isNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                throw  new IllegalArgumentException("1 이상의 수를 입력해주세요.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
