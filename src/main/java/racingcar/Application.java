package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        if (carNames == null) {
            carNames = "";
        }
        carNames = carNames.trim();

        Map<String, StringBuilder> racingStatus = new HashMap<>();
        Arrays.stream(carNames.split(","))
                .forEach(s -> {
                    if (s.isEmpty() || s.length() > 5) {
                        throw new IllegalArgumentException("자동차 이름을 입력해주세요");
                    } else {
                        racingStatus.put(s.trim(), new StringBuilder());
                    }
                });

        System.out.println("시도 할 횟수 몇 회인가요?");
        String round = Console.readLine();
        if (round == null) {
            round = "";
        }
        round = round.trim();
        if (round.isEmpty() || !round.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 숫자 입니다");
        }


        int roundToInt = Integer.parseInt(round);
        for(int i = 0; i < roundToInt; i++) {

            for (String key : racingStatus.keySet()) {
                if (Randoms.pickNumberInRange(0, 9) >= 4)
                    racingStatus.get(key).append("-");
            }
        }
    }
}
