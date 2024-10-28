package racingcar;

public class Application {
    public static void main(String[] args) {

        RacingCarView racingCarView = new RacingCarView();
        RacingCarModel racingCarModel = new RacingCarModel();
        RacingCarController racingCarController = new RacingCarController(racingCarView, racingCarModel);

        racingCarController.run();
    }
}
