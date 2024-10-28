package racingcar.service;

import racingcar.common.constant.OutputConstant;
import racingcar.model.GameResult;
import racingcar.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGamePresenter {

    public String presentGameResult(GameResult result) {
        StringBuilder output = new StringBuilder();
        output.append(OutputConstant.RESULT_HEADER).append("\n");

        // 게임 진행 상황 출력
        result.getProgress().forEach(turnState -> {
            turnState.forEach(car ->
                output.append(formatCarPosition(car)).append("\n")
            );
            output.append("\n");
        });

        // 우승자 출력
        output.append(OutputConstant.WINNER_HEADER);
        output.append(formatWinners(result.getWinners()));

        return output.toString();
    }

    private String formatCarPosition(RacingCar car) {
        return car.getName() + " : " + "-".repeat(car.getRaceResultLength());
    }

    private String formatWinners(List<RacingCar> winners) {
        return winners.stream()
            .map(RacingCar::getName)
            .collect(Collectors.joining(", "));
    }
}
