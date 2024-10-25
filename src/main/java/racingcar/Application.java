package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
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

        for (int i = 0; i < Integer.parseInt(gameCount); i++) {
            startGame(racingCar, splitRacingCarName);
        }

    }

    // 게임의 순서는 자동차 이름을 입력 받은 순서대로 진행한다.
    public static void startGame(Map<String, Integer> racingCar, String[] splitRacingCarName) {
        for (int i = 0; i < racingCar.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                racingCar.put(splitRacingCarName[i], racingCar.get(splitRacingCarName[i]) + 1);
            }
        }
    }


}
