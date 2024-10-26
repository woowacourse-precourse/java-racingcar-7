package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = getCarNames();
            System.out.println("입력한 자동차 이름: " + carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> getCarNames(){
        System.out.println("자동차 이름을 입력해주세요.");
        String inputCarName = Console.readLine();
        return validCarNames(inputCarName);
    }

    private static List<String> validCarNames(String userInput){
        List<String> carNames = Arrays.asList(userInput.split(","));

        for(String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 입력 가능합니다.");
            }
        }

        return carNames;
    }

}
