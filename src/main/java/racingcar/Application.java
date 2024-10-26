package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationContext applicationContext = new ApplicationContext();
        Game game = new Game(applicationContext);
        game.run();
    }
}
