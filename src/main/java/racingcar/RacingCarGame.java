package racingcar;

public class RacingCarGame implements Game {

    private final ApplicationView applicationView;

    public RacingCarGame(ApplicationView applicationView) {
        this.applicationView = applicationView;
    }

    @Override
    public void play() {
        inputRacingCar();
    }

    private void inputRacingCar() {
        String responseCars = applicationView.requestInputCars();
    }
}
