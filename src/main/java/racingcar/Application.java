package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public List<String> setCarName(String input) {
        List<String> carName;
        try {
            carName = Arrays.asList(input.replace(" ", "").split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException(); // exception
        }
        carNameLengthChecker(carName);
        return carName;
    }

    public void carNameLengthChecker(List<String> carName) {
        for (String name : carName) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }


}


