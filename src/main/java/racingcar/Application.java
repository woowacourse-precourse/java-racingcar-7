package racingcar;


import IO.Input;
import race.Race;

public class Application {

    private final Input input;
    private final Race race;

    public Application() {

        this.input = new Input();
        this.race = new Race();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();
    }

    public void run() {

        String cars = input.inputCars();
        String attempt = input.inputAttempt();

        String result;

        result = race.Racing(cars, attempt);
    }
}
