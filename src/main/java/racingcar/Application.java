package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Racing racing = new Racing();

        output.printInit();
        List<Car> cars = input.getCarName();
        output.printAttemptCountMessage();
        int attemptCount = input.getAttemptCount();

        racing.play(cars, attemptCount);

        List<String> winners = racing.getWinner(cars);
        output.printWinner(winners);
    }
}