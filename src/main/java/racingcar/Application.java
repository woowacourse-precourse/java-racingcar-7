package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = getCarNamesFromUser();
            int attempts = getAttemptsFromUser();
            RacingGame racingGame = new RacingGame(carNames, attempts);
            racingGame.startRace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e; // 예외를 다시 던져서 프로그램을 종료
        }
    }

    private static List<String> getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // 유효성 검사를 즉시 실행하여 예외 발생 시 더 이상 진행되지 않도록 함
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
            // 중복된 이름이 있는지 확인
            long distinctCount = carNames.stream().distinct().count();
            if (carNames.size() != distinctCount) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    private static int getAttemptsFromUser() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
