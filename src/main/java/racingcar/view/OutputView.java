package racingcar.view;

import racingcar.dto.RacingRoundResult;
import racingcar.model.RacingCars;
import racingcar.util.io.OutputConsole;

import java.util.List;

public class OutputView {

    public void printInputCarNames() {
        OutputConsole.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTryCount() {
        OutputConsole.println("시도할 회수는 몇회인가요?");
    }

    public void printRacingRoundResults(List<RacingRoundResult> racingRoundResults) {
        OutputConsole.println();
        OutputConsole.println("실행 결과");
        printRoundResults(racingRoundResults);
    }

    public void printWinners(RacingCars racingCars) {
        OutputConsole.println("최종 우승자 : " + racingCars.getJoinedNames(", "));
    }

    private void printRoundResults(List<RacingRoundResult> racingRoundResults) {
        racingRoundResults.forEach(this::printRoundResult);
    }

    private void printRoundResult(RacingRoundResult racingRoundResult) {
        racingRoundResult.value().forEach((carName, position) -> {
            OutputConsole.println(carName + " : " + getDashes(position));
        });

        OutputConsole.println();
    }

    private String getDashes(Integer position) {
        return "-".repeat(position);
    }
}
