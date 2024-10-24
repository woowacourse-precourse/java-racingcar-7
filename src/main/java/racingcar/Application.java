package racingcar;

import static racingcar.Car.makeCarArrayList;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        String[] carnames = Console.readLine().split(",");
        ArrayList<Car> raceCars = makeCarArrayList(carnames);
    }
}
