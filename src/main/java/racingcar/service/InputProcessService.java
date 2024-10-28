package racingcar.service;

import racingcar.dto.GameStartDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessService {
    public void inputValidation(GameStartDTO userInput){
        // carsInput 검증
        carsInputValidation(userInput.getCarsInput());

        // roundInput 검증
        roundInputValidation(userInput.getRoundInput());
    }

    public void carsInputValidation(String carsInput){
        carsInput = carsInput.trim();

        if(carsInput.length() == 0){
            throw new IllegalArgumentException("[자동차 이름 입력 오류] 입력이 없습니다.");
        }

        // , 로 시작하거나 끝이 나는 경우
        if(carsInput.charAt(0) == ',' || carsInput.charAt(carsInput.length()-1) == ','){
            throw new IllegalArgumentException("[자동차 이름 입력 오류] 자동차의 이름은 한 글자 이상만 가능합니다.");
        }

        String[] carArray = carsInput.split(",");
        List<String> carList = new ArrayList<>(Arrays.asList(carArray));

        for(String car : carList){
            car = car.trim();

            if(car.length() == 0){
                throw new IllegalArgumentException("[자동차 이름 입력 오류] 자동차의 이름은 한 글자 이상만 가능합니다.");
            }

            if(car.length() > 5){
                throw new IllegalArgumentException("[자동차 이름 입력 오류] 자동차의 이름은 다섯 글자 이하만 가능합니다. : "+car);
            }
        }
    }

    public void roundInputValidation(String roundInput){
        int round;

        try{
            roundInput.trim();
            round = Integer.parseInt(roundInput);
        } catch (Exception e){
            throw new IllegalArgumentException("[시도 횟수 입력 오류] 시도 횟수는 띄어쓰기 없는 정수로 입력해주세요.");
        }

        if(round <= 0){
            throw new IllegalArgumentException("[시도 횟수 입력 오류] 시도 횟수는 0회 이상 가능합니다.");
        }
    }

    public List<String> processCarsInput(String carsInput){
        String[] carArray = carsInput.split(",");

        List<String> carList = new ArrayList<>(Arrays.asList(carArray));

        carList = carList.stream()
                .map(String::trim)
                .collect(Collectors.toList());

        return carList;
    }

    public Integer processRoundInput(String roundInput){
        return Integer.parseInt(roundInput.trim());
    }
}
