package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printResultText() {
        System.out.println(DisplayedMessage.OUTPUT_EXECUTE_RESULT_TEXT.getValue());
    }

    public void printOneMoveResult(final List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        List<String> carProgressList = carList.stream().map(this::getOutPut).toList();
        carProgressList.forEach(sb::append);
        System.out.println(sb);
    }

    private String getOutPut(final Car car) {
        String scoreHyphen = "-".repeat(car.getMoveCnt());
        return String.format("%s : %s%n", car.getName(), scoreHyphen);
    }

    public void printWinners(final String winners) {
        System.out.println(DisplayedMessage.OUTPUT_WINNER_MESSAGE.getValue() + winners);
    }
}
