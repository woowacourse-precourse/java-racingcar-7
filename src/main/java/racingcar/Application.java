package racingcar;

public class Application {
    public static void main(String[] args) {
        int round = Integer.parseInt(InputUtil.inputNumber());
        String names = InputUtil.inputNames();
        Race race = new Race(new RandomNumberGenerator(), Car.createInstances(names));
        race.run(round);
        OutputUtil.printResult(race.getWinners());
    }
}
