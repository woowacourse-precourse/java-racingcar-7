package racingcar;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        view.showInputView();
        Game game = new Game(view.getCarNames(), view.getCount());
        game.start();
    }
}
