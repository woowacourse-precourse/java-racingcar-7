package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {

    static final int MAX_NAME = 5;

    public String inputCars() {
        String input;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine();
        isVaildInputEmpty(input);
        return input;
    }

    public int inputCount() {
        String input;

        System.out.println("시도할 횟수는 몇 회 인가요");
        input = Console.readLine();

        return isVaildNum(input);
    }

    public List<String> inputCarNames(String input) {
        String[] names = input.split(",");

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
            isVaildName(names[i]);
        }
        return Arrays.asList(names);
    }

    private void isVaildInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비었습니다.");
        }
    }

    public void isVaildName(String name) {
        if (name.length() > MAX_NAME || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 입력해주세요.");
        }
        if (!name.matches("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*")) {
            throw new IllegalArgumentException("이름에 특수문자가 있습니다.");
        }
    }

    public int isVaildNum(String input) {
        try {
            isVaildInputEmpty(input);
            int count = Integer.parseInt(input);
            isVaildPositive(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void isVaildPositive(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해야합니다.");
        }
    }

}
