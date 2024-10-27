package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
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
        start();
        decideWinners();
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

    private void start() {
        view.displayStartRacing();
        while (turn > 0) {
            moveCars();
            turn--;
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int rand = Randoms.pickNumberInRange(0, 9);
            if (rand >= 4) {
                car.moveForward();
            }
            view.displayCarState(car.getName(), car.getDistance());
        }
        view.displayCurrentTurnOver();
    }

    private void decideWinners() {
        List<String> winnersName = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            int currentDistance = car.getDistance();
            if (currentDistance < maxDistance) {
                continue;
            } else if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                winnersName.clear();
            }
            winnersName.add(car.getName());
        }
        view.displayWinners(winnersName);
    }
}
