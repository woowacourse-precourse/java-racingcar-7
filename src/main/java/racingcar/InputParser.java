package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String CARNAME_DELIMITER = ",";

    public static List<Car> stringToCarList(String input) {
        List<Car> carList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        String[] carNames = input.split(CARNAME_DELIMITER, -1);
        for(String carName : carNames){
            if(list.contains(carName)){
                throw new IllegalArgumentException("dd");
            }
            list.add(carName);
        }

        for (String carName : input.split(CARNAME_DELIMITER, -1)) {
            carList.add(Car.from(carName.trim()));
        }

        return carList;
    }

    private static String[] carNamesSplit(String input) {
        return input.split(CARNAME_DELIMITER, -1);
    }

    public static int stringToRound(String input) {
        return Integer.parseInt(input);
    }
}
