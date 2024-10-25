package racingcar;

import java.util.List;
import racingcar.domain.Car;

public class Application {
    private UserInputManager userInputManager;
    private Racing racing;

    public Application() {
        this.userInputManager = new UserInputManager();
        this.racing = new Racing();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        List<Car> carList = this.userInputManager.createCar();
        int repeat = this.userInputManager.createRepeat();
        this.userInputManager.close();
        this.racing.setting(carList, repeat);
        this.racing.start();
    }


}
