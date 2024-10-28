package racingcar;


import IO.Input;
import IO.Output;
import race.Race;

public class Application {

    private final Input input;
    private final Race race;
    private final Output output;

    public Application() {

        this.input = new Input();
        this.race = new Race();
        this.output = new Output();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();
    }

    public void run() {

        String cars = input.inputCars();
        String attempt = input.inputAttempt();

        System.out.println();

        String result;

        result = race.racing(cars, attempt);

        output.printResult(result);
    }
}
