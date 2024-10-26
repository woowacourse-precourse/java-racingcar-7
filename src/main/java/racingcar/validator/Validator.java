package racingcar.validator;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Validator {

    public static String validateCarNameUnderFive(String carName){

        if(carName.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해 주세요.");
        }

        return carName;
    }

    public static String validateCommaSeparatorOrNull(String inputCarName){

        if(inputCarName.isBlank()){
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        if(!inputCarName.contains(",")){
            throw new IllegalArgumentException("쉼표를 이용해서 자동차를 구분해 주세요.");
        }

        return inputCarName;
    }

    public static Integer validateNotNumberOrNull(String trialCount){

        try{
            if(trialCount.isBlank()){
                throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
            }

            return Optional.of(Integer.parseInt(trialCount))
                    .filter(count -> count >= 1)
                    .orElseThrow(() -> new IllegalArgumentException("시도 횟수는 1회 이상으로 입력해 주세요."));


        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static List<Car> validateSameCarName(List<Car> carList){

        Set<String> carNames = new HashSet<>();

        carList.stream()
                .map(Car::getName)
                .forEach(name -> {
                    if (!carNames.add(name)) {
                        throw new IllegalArgumentException("중복된 이름을 구분해 주세요.");
                    }}
                );

        return carList;
    }

}
