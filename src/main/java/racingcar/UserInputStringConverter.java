package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputStringConverter {
    public static List<String> toList(String userInputString){
        String[] carArray =  userInputString.split(",");
        return new ArrayList<>(Arrays.asList(carArray));
    }
}
