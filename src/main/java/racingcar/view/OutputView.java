package racingcar.view;

import java.util.Collection;
import racingcar.message.OutputMessage;
import racingcar.message.SeparatorPattern;
import racingcar.model.RacingCars;

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

    public void printWinners(Collection<String> names) {
        if (names == null || names.isEmpty()) {
            System.out.println(OutputMessage.NO_WINNER.getMessage());
            return;
        }
        String winners = String.join(SeparatorPattern.COMMA.getPattern(), names);
        System.out.println(OutputMessage.FINAL_WINNER.getMessage() + winners);
    }
}
