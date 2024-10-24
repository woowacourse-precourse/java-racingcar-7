package racingcar;

public class GamePack {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CarRegisterManager carRegisterManager = new CarRegisterManager();

    public void play() {
        Racing racing = initRacing();
        Track track = initTrack();

    }

    public Racing initRacing() {
        String names = inputView.inputRacingCarNames();
        RacingCars racingCars = carRegisterManager.registerRacingCars(names);

        return Racing.from(racingCars);
    }

    public Track initTrack() {
        int lap = inputView.inputLap();

        return Track.from(lap);
    }

}
