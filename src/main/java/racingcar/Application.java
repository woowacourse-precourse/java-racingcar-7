package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void inputName() {
        input = Console.readLine();
        Pattern p = Pattern.compile(regExpForName);
        Matcher m = p.matcher(input);

        if (!m.matches()) {
            throw new IllegalArgumentException();
        }

        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public static void inputNumberOfTry() {
        String number = Console.readLine();
        Pattern p = Pattern.compile(regExpForNumber);
        Matcher m = p.matcher(number);

        if (!m.matches()) {
            throw new IllegalArgumentException();
        }
        numberOfTry = Integer.parseInt(number);
    }
}