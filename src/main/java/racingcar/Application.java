package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = input().split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        int totalMoves;
        try {
            totalMoves = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 올바르게 입력해주세요");
        }

        List<Car> winners = new RacingGame().run(carNames, totalMoves);
        List<String> winnerNames = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());

        String output = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + output);
    }

    private static String input() {
        String input = Console.readLine();
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
