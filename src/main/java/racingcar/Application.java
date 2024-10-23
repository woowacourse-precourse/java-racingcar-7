package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        if (carNames.length < 2) {
            throw new IllegalArgumentException("자동차를 2개 이상 등록하세요.");
        }
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            } else if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
            }
        }

    }
}
