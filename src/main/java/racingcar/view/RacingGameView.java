package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RacingGameView {
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> inputNames = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .toList();
        validateInputNames(inputNames);
        return inputNames;
    }

    public int inputAttempt() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printGameStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRacingStatus(Map<String, Integer> status) {
        status.forEach((name, position) ->
                System.out.printf("%s : %s\n", name, "-".repeat(position))
        );
        System.out.println();
    }

    public void printWinner(List<String> winnerCarNames) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerCarNames));
    }

    private void validateInputNames(List<String> inputNames) {
        if (inputNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
