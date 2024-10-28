package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    private static String input;
    private static int numberOfTry;

    static final String regExpForName = "^([A-Za-z가-힣]{1,5})(,[A-Za-z가-힣]{1,5})*$";
    static final String regExpForNumber = "^\\d+$";

    private static ArrayList<Car> cars;
    private static View view;

    public static void main(String[] args) {
        cars = new ArrayList<Car>();
        view = new View(cars);

        inputName();
        inputNumberOfTry();
    }

    public static void inputName(){
        input = Console.readLine();

    }
    public static void inputNumberOfTry(){
        String number = Console.readLine();
        numberOfTry = Integer.parseInt(number);
    }
}