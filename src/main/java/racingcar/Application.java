package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNamesString = Console.readLine();
        String[] carNames = carNamesString.split(",");
        if (carNamesString.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() >= 5) {
                throw new IllegalArgumentException();
            }
        }

        Map<String, Integer> carMap = new HashMap<>();
        for(int i=0;i< carNames.length;i++) {
            carMap.put(carNames[i], 0);
        }
        String trialCountString = Console.readLine();
        int trialCount = Integer.parseInt(trialCountString);

        for(int i=0;i<trialCount;i++) {
            for(int j=0;j<carNames.length;j++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if(randomNumber >= 4) {
                    carMap.put(carNames[j], carMap.getOrDefault(carNames[j], 0) + 1);
                }
                StringBuilder answer = new StringBuilder();
                Integer winningCount = carMap.get(carNames[j]);
                for(int k=0;k<winningCount;k++) {
                    answer.append("-");
                }
                System.out.println(carNames[j] + " : "  + answer);
            }
            System.out.println();
        }
        int max = Integer.MIN_VALUE;

        for (String carName : carMap.keySet()) {
            max = Math.max(max, carMap.get(carName));
        }

        List<String> winnerList = new ArrayList<>();
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) == max) {
                winnerList.add(carName);
            }
        }
        String winner = String.join(",", winnerList);
        System.out.println("최종 우승자 : "+ winner);
    }
}
