package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        //
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsNameInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String chanceInput = Console.readLine();

        Map<String, Integer> carsInfo = new HashMap<>();
        for(String carName : carsNameInput.split(",")) {
            carsInfo.put(carName, 0);
        }

        for(int i = 0; i < Integer.parseInt(chanceInput); i++) {
            racing(carsInfo);
            printResult();
        }

        // 우승자 가려내기
    }
    static void racing(Map<String, Integer> carsInfo) {
        // 자동차 별로 전진하는 것 구현

    }
    static void printResult() {
        // 출력하기
    }
}
