package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            // 사용자 입력 받는 부분
            List<String> carNames = inputCarNames();
            System.out.println("유효한 자동차 이름 목록: " + carNames);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
            throw e;
        }
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();  // 사용자 입력 받기

        String[] carNames = input.split(",");
        List<String> validCarNames = new ArrayList<>();

        for (String name : carNames) {
            name = name.trim();  // 공백 제거
            validateCarName(name);  // 이름 유효성 검사
            validCarNames.add(name);
        }

        return validCarNames;
    }

    private static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 입력되어야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 구성되어야 합니다.");
        }
        if (!Pattern.matches("^[a-zA-Z0-9]*$", name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영문자와 숫자에 한하여 구성 가능합니다.");
        }
    }
}
