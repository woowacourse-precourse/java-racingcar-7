package racingcar.service;

import racingcar.dto.GameStartDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessService {
    private static final int CAR_LENGTH_MIN_LIMIT = 1;
    private static final int CAR_LENGTH_MAX_LIMIT = 5;
    private static final int ROUND_MIN_LIMIT = 1;

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
            String exceptionMessage = String.format("[자동차 이름 입력 오류] 자동차의 이름은 최소 %d자 이상이어야 합니다.\n", CAR_LENGTH_MIN_LIMIT);
            exceptionMessage += String.format("입력: %s, 입력 길이: %d", "", 0);
            throw new IllegalArgumentException(exceptionMessage);

        }

        String[] carArray = carsInput.split(",");
        List<String> carList = new ArrayList<>(Arrays.asList(carArray));

        for(String car : carList){
            car = car.trim();

            if(car.length() < CAR_LENGTH_MIN_LIMIT){
                String exceptionMessage = String.format("[자동차 이름 입력 오류] 자동차의 이름은 최소 %d자 이상이어야 합니다.", CAR_LENGTH_MIN_LIMIT);
                exceptionMessage += String.format("입력: %s, 입력 길이: %d", car, car.length());
                throw new IllegalArgumentException(exceptionMessage);
            }

            if(car.length() > CAR_LENGTH_MAX_LIMIT){
                String exceptionMessage = String.format("[자동차 이름 입력 오류] 자동차의 이름은 최대 %d자까지 입력할 수 있습니다.", CAR_LENGTH_MAX_LIMIT);
                exceptionMessage += String.format("입력: %s, 입력 길이: %d", car, car.length());
                throw new IllegalArgumentException(exceptionMessage);
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

        if(round < ROUND_MIN_LIMIT){
            String exceptionMessage = String.format("[시도 횟수 입력 오류] 시도 횟수는 최소 %d회 이상이어야 합니다.", ROUND_MIN_LIMIT);
            throw new IllegalArgumentException(exceptionMessage);
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
