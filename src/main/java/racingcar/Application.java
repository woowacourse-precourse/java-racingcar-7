package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        view.showInputView();

        Game game = new Game(view.getCarNames(), view.getCount());
        List<String> winners = game.run();

        view.showOutputView(winners);
    }
}
