package racingcar;

import racingcar.domain.Cars;

public class ApplicationService {

    private final UserInputService userInputService;

    public ApplicationService() {
        this.userInputService = new UserInputService();
    }

    public void run() {
        Cars cars = this.userInputService.createCar();
        int repeat = this.userInputService.createRepeat();
        this.userInputService.close();

        Racing racing = new Racing(cars, repeat);
        racing.start();
        Cars winners = racing.getWinners();
    }
}
