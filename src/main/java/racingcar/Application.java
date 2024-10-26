package racingcar;

public class Application {
    public static void main(String[] args) {

        MessagePrinter messagePrinter = new MessagePrinter();
        InputReader inputReader = new InputReader();

        System.out.println(messagePrinter.carNameGuideMessage);
        String userInputCar = inputReader.getUserInput();
    }
}
