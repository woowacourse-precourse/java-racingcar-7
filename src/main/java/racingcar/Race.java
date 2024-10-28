package racingcar;

public class Race {
    private OutputView outputView;

    public Race(OutputView outputView) {
        this.outputView = outputView;
    }

    public void play(Cars cars, PlayCount playCount) {
        outputView.printRaceStart();

        int count = playCount.getPlayCount();
        for (int i = 0; i < count; i++) {
            cars.foward();
            outputView.printRaceProcess(cars);
        }

        outputView.printWinners(cars);
    }
}
