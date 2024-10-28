package racingcar;

import java.util.HashMap;

public class Controller {

    private final Input inputView;
    private final Output outputView;
    private final Race race;

    public Controller() {
        inputView = new Input();
        outputView = new Output();
        race = new Race();
    }

    public void run() {
        HashMap<String, Integer> car = inputView.getCar();
        Integer number = inputView.getNumber();

        HashMap<String, Integer> racing = race.race(car, number);
        HashMap<String, Integer> result = race.winner(racing);

        outputView.print(result);
    }
}
