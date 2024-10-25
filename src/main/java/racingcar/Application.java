package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 경주할 자동차 이름 입력(참가자 수)
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        try {
            validateInput(input);
            System.out.println(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    // 사용자 입력에 특수 문자와 공백이 있는지 확인하는 메서드
    private static void validateInput(String input) {
        if (input.matches(".*[ \'`%@:=>$_#+\\[;~!(*)\\]&?}\\{/.<|\\-\"^\\\\].*")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
