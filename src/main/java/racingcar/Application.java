package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String[] carNames = inputCarNames();
        int totalMoves = inputTotalMoves();

        List<Car> winners = new RacingGame().run(carNames, totalMoves);
        List<String> winnerNames = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());

        printWinner(winnerNames);
    }

    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input().split(",");
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

    private static void printWinner(final List<String> winnerNames) {
        output("최종 우승자 : "  + String.join(", ", winnerNames));
    }

    private static void output(final String output) {
        System.out.println(output);
    }
}
