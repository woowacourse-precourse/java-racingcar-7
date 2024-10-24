package racingcar.view;

import racingcar.dto.RacingRoundResult;
import racingcar.model.RacingCars;
import racingcar.util.io.OutputConsole;

import java.util.List;

public class OutputView {

    private final String COLON = ":";
    private final String DASH = "-";
    private final String COMMA = ",";
    private final String SPACE = " ";

    public void printInputCarNames() {
        String message = String.format("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)", COMMA);
        OutputConsole.println(message);
    }

    public void printInputTryCount() {
        String message = "시도할 회수는 몇회인가요?";
        OutputConsole.println(message);
    }

    public void printRacingRoundResults(List<RacingRoundResult> racingRoundResults) {
        String message = "실행 결과";

        OutputConsole.println();
        OutputConsole.println(message);
        printRoundResults(racingRoundResults);
    }

    public void printWinners(RacingCars racingCars) {
        String message = String.format("최종 우승자 %s %s", COLON, racingCars.getJoinedNames(COMMA + SPACE));
        OutputConsole.println(message);
    }

    private void printRoundResults(List<RacingRoundResult> racingRoundResults) {
        racingRoundResults.forEach(this::printRoundResult);
    }

    private void printRoundResult(RacingRoundResult racingRoundResult) {
        racingRoundResult.value().forEach((carName, position) -> {
            String message = String.format("%s %s %s", carName, COLON, getDashes(position));

            OutputConsole.println(message);
        });

        OutputConsole.println();
    }

    private String getDashes(Integer position) {
        return DASH.repeat(position);
    }
}
