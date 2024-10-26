package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        if (carName == null || carName.isEmpty()){
            throw new IllegalArgumentException("경주할 자동차 이름 입력 필요함.");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();

        List<String> carNameList = Arrays.asList(carName.split(","));
        
        for (int i = 0; carNameList.size() > i; i++){
            if (carNameList.get(i).length() > MAX_CAR_NAME_LENGTH){
                throw new IllegalArgumentException("자동차의 이름은 5글자를 넘길 수 없습니다.");
            }
        }
    }
}