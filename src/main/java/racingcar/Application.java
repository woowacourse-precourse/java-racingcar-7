package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String RaceCarNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int RaceCount = Integer.parseInt(Console.readLine());


        String[] CarNames = RaceCarNames.split(",");
        HashMap<String, Integer> carRaceSituation = new HashMap<>();
        for (int i = 0; i < CarNames.length; i++) {
            if (CarNames[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            carRaceSituation.put(CarNames[i], 0);
        }

    }
}
