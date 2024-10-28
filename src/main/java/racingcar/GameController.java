package racingcar;

public class GameController {

    private final CarService carService;

    public GameController() {
        this.carService = DependencyInjectionConfig.carService();
    }



}
