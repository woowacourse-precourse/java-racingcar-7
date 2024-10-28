package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameInput implements CarManager{
    private static final CarConstants carConstants = new CarConstants();

    public List<Car> carNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 "+carConstants.SEPARATOR_NAME+"("+carConstants.SEPARATOR+") 기준으로 구분)");
        String carNames = Console.readLine();
        validateCarName(carNames);
        List<String> carNameList = carNamesSplit(carNames);
        List<Car> CarList = carNameToCar(carNameList);

        return CarList;
    }

    private List<Car> carNameToCar(List<String> carNameList) {
        List<Car> CarList = new ArrayList<>();
        for(String carName : carNameList){
            CarList.add(new Car(carName));
        }
        return CarList;
    }

    private List<String> carNamesSplit(String carNames) {
        String[] carNameArray = carNames.split(carConstants.SEPARATOR);
        carNamesTrim(carNameArray);

        List<String> carNameList = Arrays.asList(carNameArray);
        validateCarNameLength(carNameList);

        return carNameList;
    }

    private void validateCarNameLength(List<String> carNameList) {
        for(String carName: carNameList){
            if(carName.length() > carConstants.CarNameLength)
                throw new IllegalArgumentException("error: 문자열이 정해진 길이를 초과합니다");
        }
    }

    private void carNamesTrim(String[] carNameArray) {
        for (int i = 0; i < carNameArray.length; i++) {
            carNameArray[i] = carNameArray[i].trim();
        }
    }

    private void validateCarName(String carNames) {
        validateCarNameEmpty(carNames);
        validateCarNameFormat(carNames);
    }

    private void validateCarNameFormat(String carNames) {
        if(!carNames.matches(carConstants.VALID_INPUT_PATTERN))
            throw new IllegalArgumentException("error: 입력받은 문자열의 형식이 불일치합니다");
    }


    private void validateCarNameEmpty(String carNames) {
        if(carNames == null || carNames.isEmpty())
            throw new IllegalArgumentException("error: 입력받은 문자열이 빈문자열 또는 null입니다");
    }

}
