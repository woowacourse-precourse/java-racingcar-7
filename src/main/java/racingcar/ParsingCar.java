package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ParsingCar {
    public static List<String> parseInputCarToList(String userInput) {
        List<String> list = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            list.add(carName.trim());
        }
        return list;
    }
}
