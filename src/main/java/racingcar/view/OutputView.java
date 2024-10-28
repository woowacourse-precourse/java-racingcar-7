package racingcar.view;

import java.util.List;
import racingcar.car.service.dto.CarMoveRespDto;
import racingcar.car.service.dto.WinnerRespDto;
import racingcar.constant.View;

public class OutputView {
    private static final String DISTANCE = "-";
    private static final String DELIMITER = ", ";
    private static final String CAR_DISTANCE_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";

    private OutputView() {
    }

    private static class OutputViewHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputView.OutputViewHolder.INSTANCE;
    }

    public void printMoveResults(List<CarMoveRespDto> moveResults) {
        StringBuilder sb = new StringBuilder();
        moveResults.forEach(moveResult -> {
            sb.append(moveResult.getCarName())
                    .append(CAR_DISTANCE_DELIMITER)
                    .append(DISTANCE.repeat(moveResult.getPosition()))
                    .append(NEW_LINE);
        });
        System.out.println(sb);
    }

    public void printWinners(List<WinnerRespDto> winners) {
        List<String> winnerNames = winners.stream()
                .map(winner -> String.valueOf(winner.getWinner()))
                .toList();
        System.out.println(View.WINNER_OUTPUT.getMessage() + String.join(DELIMITER, winnerNames));
    }
}
