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

    public void printResult(RaceResultDto raceResultDto) {
        System.out.println(NEW_LINE.message + RESULT_HEADER.message);
        raceResultDto.carsResultDtos().forEach(carsResultDto -> {
            carsResultDto.carResultDtos().forEach(carResultDto -> {
                System.out.println(carResultDto.carName() + RESULT_DELIMITER.message + RESULT_POSITION.message.repeat(
                        carResultDto.position()));
            });
            System.out.print(NEW_LINE.message);
        });
    }

    public void printWinner(WinnersDto winnersDto) {
        System.out.print(WINNER.message + String.join(WINNER_DELIMITER.message, winnersDto.winners()));
    }
}
