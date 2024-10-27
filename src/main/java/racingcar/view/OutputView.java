package racingcar.view;

import static racingcar.view.Output.NEW_LINE;
import static racingcar.view.Output.RESULT_DELIMITER;
import static racingcar.view.Output.RESULT_HEADER;
import static racingcar.view.Output.RESULT_POSITION;
import static racingcar.view.Output.WINNER;
import static racingcar.view.Output.WINNER_DELIMITER;

import racingcar.domain.race.dto.RaceResultDto;
import racingcar.domain.race.dto.WinnersDto;

public class OutputView {

    private OutputView() {
    }

    public static OutputView createOutputView() {
        return new OutputView();
    }

    public void printMessage(Output output) {
        System.out.println(output.message);
    }

}
