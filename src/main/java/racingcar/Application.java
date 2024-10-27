package racingcar;

public class Application {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();

        String[] racingCars = userInput.racingCarNameInput();
        Integer raceCount = userInput.raceCountInput();
    }
}
