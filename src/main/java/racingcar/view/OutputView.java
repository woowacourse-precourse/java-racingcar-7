package racingcar.view;

import racingcar.message.OutputMessage;
import racingcar.message.SeparatorPattern;
import racingcar.model.RacingCars;
import racingcar.dto.OutputResponse;

public class OutputView {

    public void printRaceStart() {
        System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
    }

    public void printRaceStatus(RacingCars racingCars) {
        racingCars.getCars().forEach(car -> printCarStatus(car.getName(), car.getPosition()));
        System.out.println();
    }

    private void printCarStatus(String name, int position) {
        String progress = SeparatorPattern.MOVE_MARKER.getPattern().repeat(position);
        System.out.println(name + SeparatorPattern.RESULT_SEPARATOR.getPattern() + progress);
    }

    public void printWinners(OutputResponse outputResponse) {
        String winners = outputResponse.winners().isEmpty()
                ? OutputMessage.NO_WINNER.getMessage()
                : OutputMessage.FINAL_WINNER.getMessage() + String.join(SeparatorPattern.COMMA.getPattern(), outputResponse.winners());

        System.out.println(winners);
    }
}
