package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;
import racingcar.view.output.ConsoleWriter;
import racingcar.view.output.Writer;

public class OutputView {

    private static final Writer DEFAULT_WRITER = new ConsoleWriter();
    private static final String POSITION_TEXT = "-";
    private static final String CAR_RESULT_DELIMITER = " : ";
    private static final String WINNER_DELIMITER = ", ";

    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public OutputView() {
        this(DEFAULT_WRITER);
    }

    public void outputRoundResult(RoundDto roundResult) {
        roundResult.cars()
                .forEach(this::outputCarResult);
    }

    private void outputCarResult(CarDto car) {
        writer.writeLine(car.name() + CAR_RESULT_DELIMITER + POSITION_TEXT.repeat(car.position()));
    }

    public void outputWinners(List<String> winners) {
        writer.writeLine("최종 우승자 : " + toWinnersText(winners));
    }

    private String toWinnersText(List<String> winners) {
        return String.join(WINNER_DELIMITER, winners);
    }
}
