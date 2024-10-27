package racingcar;

public class Application {
    public static void main(String[] args) {
        String names = InputUtil.inputNames();
        int round = Integer.parseInt(InputUtil.inputNumber());
        Race race = new Race(new RandomNumberGenerator(), Car.createInstances(names));
        race.run(round);
        OutputUtil.printResult(race.getWinners());
    }
}
