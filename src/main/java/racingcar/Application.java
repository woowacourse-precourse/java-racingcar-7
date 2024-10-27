package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        validateCarNames(carNames);

        // TODO: 검증 로직 적용 과정 확인
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceAttemptCount = validateRaceAttemptCount(readLine());

        System.out.println(Arrays.toString(carNames));
    }

    private static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static int validateRaceAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
