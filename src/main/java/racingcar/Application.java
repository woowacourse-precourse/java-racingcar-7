package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요,(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNameList = getCarName(input);
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static List<String> getCarName(String input){
        List<String> carNameList = Arrays.asList(input.split(","));
        validateCarName(carNameList);
        return carNameList;
    }

    public static void validateCarName(List<String> carNameList){
        for(String carName : carNameList){
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 정해주세요.");
            }
            if(carName.isBlank()){
                throw new IllegalArgumentException("자동차 이름을 1자 이상으로 정해주세요.");
            }
        }
    }
}
