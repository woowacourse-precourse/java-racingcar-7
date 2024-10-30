package racingcar.view;

import racingcar.message.OutputMessage;
import racingcar.message.SeparatorPattern;
import racingcar.model.RaceProcess;
import racingcar.dto.OutputResponse;

import java.util.Optional;

public class OutputView {

    public void printRaceStart() {
        System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
    }

    public void printRaceStatus(RaceProcess raceProcess) {
        raceProcess.getCars().forEach(car -> printCarStatus(car.getName(), car.getPosition()));
        System.out.println();
    }

    private void printCarStatus(String name, int position) {
        String progress = SeparatorPattern.MOVE_MARKER.getPattern().repeat(position);
        System.out.println(name + SeparatorPattern.RESULT_SEPARATOR.getPattern() + progress);
    }

    public void printWinners(OutputResponse outputResponse) {
        String winners = Optional.of(outputResponse.winners())
                .filter(winnerList -> !winnerList.isEmpty())
                .map(winnerList -> OutputMessage.FINAL_WINNER.getMessage() + String.join(SeparatorPattern.COMMA.getPattern(), winnerList))
                .orElse(OutputMessage.NO_WINNER.getMessage());

        System.out.println(winners);
    }
}
