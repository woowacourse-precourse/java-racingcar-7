package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] carNames = inputCarNames();
    }

    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCarNames(input);
        return input.split(",");
    }

    private static void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
            }
        }
    }

    private static int inputMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int moveCount = Integer.parseInt(Console.readLine());
        validateMoveCount(moveCount);
        return moveCount;
    }

    private static void validateMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }

}
