package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        MessagePrinter messagePrinter = new MessagePrinter();
        InputReader inputReader = new InputReader();
        InputExtractor inputExtractor = new InputExtractor();

        System.out.println(messagePrinter.carNameGuideMessage);
        String userInputCar = inputReader.getUserInput();

        List<String> carNames = inputExtractor.extractCarNames(userInputCar);
    }
}