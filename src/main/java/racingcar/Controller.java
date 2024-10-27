package racingcar;
import java.util.HashMap;

public class Controller {

    private final Input inputView;
    private final Output outputView;
   // private final Calculator calculator;

    public Controller() {
        inputView = new Input();
        outputView = new Output();
       // calculator = new Calculator();
    }

    public void run() {
        HashMap<String, Integer> car = inputView.getCar();
        int number = inputView.getNumber();

        int result = random.random(input);
        outputView.printResult(result);

    }
}
