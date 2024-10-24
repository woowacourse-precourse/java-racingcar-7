package racingcar;

public class GamePack {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CarRegisterManager carRegisterManager = new CarRegisterManager();

    public void play() {
        Racing racing = initRacing();

    }

    public Racing initRacing() {
        String names = inputView.inputRacingCarNames();
        RacingCars racingCars = carRegisterManager.registerRacingCars(names);

        return Racing.from(racingCars);
    }

}
