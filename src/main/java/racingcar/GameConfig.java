package racingcar;

public class GameConfig {

    private static final GameConfig INSTANCE = new GameConfig();

    private GameConfig() {

    }

    public static GameConfig getInstance() {
        return INSTANCE;
    }

    public Game racingCarGame() {
        return new RacingCarGame(applicationView(), racingManager(), converter());
    }

    private ApplicationView applicationView() {
        return new ApplicationConsoleView();
    }

    private RacingManager<RacingCar> racingManager() {
        return new RacingCarManager(CarRaceParticipants.getInstance());
    }

    private Converter<RacingCar> converter() {
        return new RacingCarConverter();
    }
}
