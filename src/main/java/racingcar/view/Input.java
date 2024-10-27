package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    // 자동차 이름 입력
    public static String[] carInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return carNames;
    }

    // 게임 횟수 입력
    public static int gameNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}