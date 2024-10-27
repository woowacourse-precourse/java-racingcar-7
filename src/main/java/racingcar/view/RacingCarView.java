package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingCarView {

    public static List<String> requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        return List.of(input.split(","));
    }

    public static int requestAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return validateAndParseAttempts(Console.readLine());
    }

    public static void responseResultHeader() {
        System.out.println("실행 결과");
    }

    public static void responseRacingCarsResult(RacingCars racingCars) {
        racingCars.getRacingCars()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void responseWinnerRacingCars(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));

        System.out.printf("최종 우승자 : %s%n", winnerNames);
    }

    private static int validateAndParseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts < 0) {
                throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수 값이어야합니다.");
        }
    }
}
