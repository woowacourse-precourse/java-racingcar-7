package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingGame {

    private final RacingGameView view;
    private List<Car> cars;
    private int turn;

    public RacingGame(RacingGameView racingGameView) {
        this.view = racingGameView;
    }

    public void run() {
        init();
    }

    private void init() {
        createCars();
        createTurn();
    }

    private void createCars() {
        String input = view.getCarsName();
        Validator.isValidCarsName(input);

        cars = new ArrayList<>();
        Pattern pattern = Pattern.compile("([a-z]{1,5})");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String carName = matcher.group(1);
            cars.add(new Car(carName));
        }
    }

    private void createTurn() {
        String input = view.getTurn();
        Validator.isValidTurn(input);
        turn = Integer.parseInt(input);
    }
}
