package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 값  받아오기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 쉼표를 기준으로 분리
        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

//        // 이름이 올바르게 입력되었음을 확인
//        System.out.println("자동차 이름이 올바르게 입력되었습니다.");

        System.out.println("시도할 횟수를 입력하세요.");
        String attemptsInput = Console.readLine();

        int attempts;
        try {
            attempts = Integer.parseInt(attemptsInput);
            if (attempts < 1) {
                throw new IllegalArgumentException("횟수는 1 이상의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        System.out.println("자동차 이름과 시도 횟수가 올바르게 입력되었습니다.");
    }
}
