package racingcar;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameClient gameClient = appConfig.gameClient();
        gameClient.run();
    }
}
