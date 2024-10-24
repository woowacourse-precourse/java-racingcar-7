package racingcar;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(User.inputCarName());
        int gameRepeats = User.inputGameRepeat();

        for (int i = 0; i < gameRepeats; i++) {
            game.moveCar();
            game.printProgress();
        }
    }
}
