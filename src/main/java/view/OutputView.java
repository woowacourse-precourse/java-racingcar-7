package view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    private final static String EXECUTION_RESULT = "실행 결과";
    private final static String FINAL_WINNER = "최종 우승자 : ";

    public final void game(List<RacingCar> carNames, int gameCount) {
        StringBuilder output = new StringBuilder();

        if (gameCount == 0) {
            output.append(EXECUTION_RESULT).append("\n");
        }

        carNames.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getDistance()))
                .forEach(result -> output.append(result).append("\n"));
        output.append("\n");
        System.out.print(output);
    }

    public final void printWinner(List<String> winners) {
        System.out.print(FINAL_WINNER);
        System.out.println(String.join(", ", winners));
    }
}
