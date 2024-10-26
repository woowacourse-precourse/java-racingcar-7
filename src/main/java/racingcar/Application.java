package racingcar;

public class Application {
    public static void main(String[] args) {
        IO io = new IO();
        String[] carName = io.inputCars();
        int totalCount = io.inputCount();

        Challenge challenge1 = new Challenge(totalCount);
        for (int i = 0; i < carName.length; i++) {
            challenge1.addCar(new Car(carName[i]));
        }

        challenge1.runChallenge();
    }
}
