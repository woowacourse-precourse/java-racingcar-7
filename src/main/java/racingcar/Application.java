package racingcar;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();

        String inputCars = Util.getInputValue();
        String inputCount = Util.getInputValue();

        race.run(inputCars, inputCount);
    }
}
