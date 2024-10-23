package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printBeforeMessage() {
        System.out.println(DisplayedMessage.OUTPUT_EXECUTE_RESULT_TEXT.getValue());
    }

    public void printOneRoundResult(final List<Car> carList) {
        StringBuilder sb = buildOneRoundProgressResult(carList);
        System.out.println(sb);
    }

    private StringBuilder buildOneRoundProgressResult(final List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        List<String> carProgressList = extractCarProgressList(carList);
        carProgressList.forEach(sb::append);
        return sb;
    }

    private List<String> extractCarProgressList(final List<Car> carList) {
        return carList.stream().map(this::formatOutput).toList();
    }

    private String formatOutput(final Car car) {
        String scoreHyphen = "-".repeat(car.getMoveCnt());
        return String.format("%s : %s%n", car.getName(), scoreHyphen);
    }

    public void printWinners(final String winners) {
        System.out.println(DisplayedMessage.OUTPUT_WINNER_MESSAGE.getValue() + winners);
    }
}
