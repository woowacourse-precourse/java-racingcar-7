package racingcar.view;

import racingcar.dto.response.CarsResponse;
import racingcar.dto.response.WinnerResponse;
import racingcar.io.output.Writer;

public class OutputView {

    public static final String RESULT_OUTPUT_MESSAGE = "\n실행 결과";
    public static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    private final Writer writer;
    private boolean isFirstTrial = true;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printMovement(CarsResponse carsResponse) {
        printResultMessage();
        carsResponse.cars()
                .forEach(car -> writer.writeln(car.toString()));
        writer.writeln();
    }

    public void printWinner(WinnerResponse response) {
        writer.writef("%s%s", WINNER_OUTPUT_MESSAGE, response.toString());
    }

    private void printResultMessage() {
        if (isFirstTrial) {
            writer.writeln(RESULT_OUTPUT_MESSAGE);
            isFirstTrial = false;
        }
    }
}
