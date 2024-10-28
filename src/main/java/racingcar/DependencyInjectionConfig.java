package racingcar;

public class DependencyInjectionConfig {
    private static CarService carService;
    private static GameController gameController;

    public static synchronized CarService carService() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }

    public static synchronized GameController gameController() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }
}
