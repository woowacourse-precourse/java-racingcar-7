package racingcar;

public class Application {
    public static void main(String[] args) {
        int round = Integer.parseInt(InputUtil.inputNumber());
        String names = InputUtil.inputNames();
        Race race = new Race(new RandomNumberGenerator());
        race.run(round, Car.createInstances(names));
    }
}
