package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarName = Console.readLine();

        Map<String, Integer> racingCar = new HashMap<>();

        String[] splitRacingCarName = racingCarName.split(",");
        for (String eachRacingCarName : splitRacingCarName) {
            racingCar.put(eachRacingCarName, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameCount = Console.readLine();


    }


}
