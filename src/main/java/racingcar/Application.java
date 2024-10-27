package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringInput = Console.readLine();

        List<String> carNames = Validator.checkInputCarNames(stringInput);
        Map<String, StringBuilder> racingStatus = new HashMap<>();
        carNames.forEach(name -> racingStatus.put(name, new StringBuilder()));

        System.out.println("시도 할 횟수 몇 회인가요?");
        String numInput = Console.readLine();

        Integer round = Validator.checkInputRound(numInput);

        System.out.println("\n실행결과");
        for(int i = 0; i < round; i++) {

            for (String key: racingStatus.keySet()) {
                if (Randoms.pickNumberInRange(0, 9) >= 4)
                    racingStatus.get(key).append("-");
            }

            StringBuilder statusOutput = new StringBuilder();
            for (String key: racingStatus.keySet()) {
                statusOutput.append(key).append(" : ").append(racingStatus.get(key)).append("\n");
            }

            System.out.println(statusOutput);
        }

        int max = racingStatus.values().stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);

        StringBuilder resultOutput = new StringBuilder("최종 우승자: ");
        for(Entry<String, StringBuilder> entry : racingStatus.entrySet()) {
            if (max == entry.getValue().length()) {
                resultOutput.append(entry.getKey()).append(", ");
            }
        }

        System.out.println(resultOutput.substring(0, resultOutput.length()-2));
    }
}
