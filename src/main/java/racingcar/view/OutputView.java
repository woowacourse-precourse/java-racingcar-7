package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.Winners;

public class OutputView {

    private final OutputProcessor outputProcessor;

    private OutputView() {
        this.outputProcessor = new OutputProcessor();
    }

    private static class OutputViewHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.INSTANCE;
    }

    public void displayCars(Cars cars) {
        String formattedCars = outputProcessor.formatCars(cars);
        System.out.println(formattedCars);
    }

    public void displayWinners(Winners winners) {
        String formattedWinners = outputProcessor.formatWinners(winners);
        System.out.println(formattedWinners);
    }
}
