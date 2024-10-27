package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int totalMoves = inputTotalMoves();

        List<Car> winners = new RacingGame().run(carNames, totalMoves);
        printWinners(winners);
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = input().split(",");
        return List.of(carNames);
    }

    private static int inputTotalMoves() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수를 올바르게 입력해주세요");
        }
    }

    private static String input() {
        String input = Console.readLine();
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력은 필수입니다");
        }
        return input;
    }

    private static void printWinners(final List<Car> winners) {
        List<String> winnerNames = abstractWinnerNames(winners);
        output("최종 우승자 : "  + String.join(", ", winnerNames));
    }

    private static List<String> abstractWinnerNames(final List<Car> winners) {
        return winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private static void output(final String output) {
        System.out.println(output);
    }
}
