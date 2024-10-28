package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarValidator {
    public static List<String> validateNames(String input){
        List<String> carList = Arrays.asList(input.split(","));
        for (int i = 0; i < carList.size(); i++) {
            carList.set(i, carList.get(i).trim());
            if (carList.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5자 이내여야 합니다. ");
            }
        }
        return carList;
    }

    public void validateSameName(List<String> carList){
        List<String> nameCheck = carList;
        for (String car : carList){
            if (nameCheck.contains(car)){
                throw new IllegalArgumentException("자동차 이름 중 겹치는 이름이 있습니다.");
            }
            nameCheck.add(car);
        }
    }
}
