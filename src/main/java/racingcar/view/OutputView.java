package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;
import racingcar.view.output.ConsoleWriter;
import racingcar.view.output.Writer;

public class OutputView {

    private static final Writer DEFAULT_WRITER = new ConsoleWriter();
    private static final String POSITION_TEXT = "-";
    private static final String RESULT_DELIMITER = " : ";

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
        writer.writeLine(car.name() + RESULT_DELIMITER + POSITION_TEXT.repeat(car.position()));
    }
}
