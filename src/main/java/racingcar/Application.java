package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        List<String> racingCarNames = List.of(rawCarNames.split(","));

        for (String racingCarName : racingCarNames) {
            if (racingCarName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String rawTryCount = Console.readLine();

        if (!rawTryCount.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        int tryNum = Integer.parseInt(rawTryCount);
        if (tryNum < 1) {
            throw new IllegalArgumentException("1 이상의 양수만 입력 가능합니다.");
        }
    }
}
