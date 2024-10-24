package iohandler;

import java.util.Arrays;
import java.util.List;

public class CarNameInputHandler {

    public List<String> getSeparatedCarNameList(String userInput) {
        List<String> carNameList = Arrays.stream(userInput.split(",")).toList();

        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNameList;
    }
}
