package racingcar.view;

import racingcar.controller.dto.RaceResultDTO;
import racingcar.controller.dto.RaceResultDTO.CarResult;

public class OutputView {

    public void printWinnerNames(String... winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println(String.format("최종 우승자 : %s", winners));
    }

    public void printRoundResult(RaceResultDTO raceResultDTO) {
        System.out.println("실행 결과");
        for (CarResult result : raceResultDTO.cars()) {
            System.out.println(String.format("%s : %s", result.name(), "-".repeat(result.position())));
        }
        System.out.println();
    }

    public void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestTotalRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
