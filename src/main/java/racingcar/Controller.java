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
        race.race(car, number);
        String result = race.winner(car, number);
        outputView.print(result);

    }
}
