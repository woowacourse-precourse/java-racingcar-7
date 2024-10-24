package racingcar;

public class GamePack {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CarRegisterManager carRegisterManager = new CarRegisterManager();

    public void play() {
        Racing racing = initRacing();
        Track track = initTrack();

        startRacing(track, racing);
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

    public void startRacing(Track track, Racing racing) {
        outputView.printStartRacing();

        while (track.isLapInProgress()) {
            racing.moveCars();
            track.decrementLap();

            outputView.printRacingStatus(racing);
        }
    }

}
