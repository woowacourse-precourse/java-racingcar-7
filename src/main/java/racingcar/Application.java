package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carsString = Console.readLine().replaceAll(" ", "");

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine().replaceAll(" ", "");

        List<String> carNames = List.of(carsString.split(","));
        int tryNum = Integer.parseInt(tryNumString);

        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }

        int [] progressCounts = new int[carNames.size()];

        for (int i = 0; i < tryNum; i++) {
            for (int k = 0; k < carNames.size(); k++) {
                if (Randoms.pickNumberInRange(0, 9) > 5) {
                    progressCounts[k] += 1;
                }
                String progressBar = "-".repeat(progressCounts[k]);
                System.out.println(carNames.get(k).toString() + " : " + progressBar);
            }
            System.out.println();
        }

        List<String> winner = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < progressCounts.length; i++) {
            if (progressCounts[i] > max) {
                max = progressCounts[i];
            }
        }

        for (int i = 0; i < progressCounts.length; i++) {
            if (progressCounts[i] == max) {
                winner.add(carNames.get(i));
            }
        }

        String winnerNames = String.join(",", winner);

        System.out.println("최종 우승자 : " + winnerNames);

    }
}
