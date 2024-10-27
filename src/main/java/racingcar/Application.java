package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static final int NAME_HANDLING_CRITERIA = 5;
    public static final int RANDOM_CONDITIONS = 4;
    public static final String BAR = "-";


    public static void main(String[] args) {
        Map<String, Integer> carNamesMap = getCarNamesMap(getCarNames());

        Set<Map.Entry<String, Integer>> carNameSet = carNamesMap.entrySet();

        processAndPrint(carNameSet, carNamesMap);

        winnerPrint(getWinnerList(carNameSet, getMaxCount(carNameSet)));
    }


    private static void processAndPrint(Set<Map.Entry<String, Integer>> carNameSet, Map<String, Integer> carNamesMap) {
        int count = getCount();
        for (int i = 0; i < count; i++) {
            process(carNameSet, carNamesMap);
            processPrint(carNameSet);
        }
    }

    private static void winnerPrint(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    private static List<String> getWinnerList(Set<Map.Entry<String, Integer>> carNameSet, int maxCount) {
        List<String> winnerList = new ArrayList<>();
        for (Map.Entry<String, Integer> carName : carNameSet) {
            if (carName.getValue() == maxCount) {
                winnerList.add(carName.getKey());
            }
        }
        return winnerList;
    }

    private static int getMaxCount(Set<Map.Entry<String, Integer>> carNameSet) {
        int maxCount = 0;
        for (Map.Entry<String, Integer> carName : carNameSet) {
            if (carName.getValue() > maxCount) {
                maxCount = carName.getValue();
            }
        }
        return maxCount;
    }

    private static void processPrint(Set<Map.Entry<String, Integer>> carNameSet) {
        for (Map.Entry<String, Integer> carName : carNameSet) {
            System.out.println(carName.getKey() + " : " + BAR.repeat(carName.getValue()));
        }
        System.out.println();
    }

    private static void process(Set<Map.Entry<String, Integer>> carNameSet, Map<String, Integer> carNamesMap) {
        for (Map.Entry<String, Integer> carName : carNameSet) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= RANDOM_CONDITIONS) {
                carNamesMap.put(carName.getKey(), carName.getValue() + 1);
            }
        }
    }

    private static Map<String, Integer> getCarNamesMap(String[] carNames) {
        Map<String, Integer> carNamesMap = new LinkedHashMap<>();
        for (String carName : carNames) {
            if (carName.length() > NAME_HANDLING_CRITERIA) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이내로 입력해주세요!");
            }
            carNamesMap.put(carName, 0);
        }
        return carNamesMap;
    }

    private static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        return Integer.parseInt(inputCount);
    }

    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.replaceAll(" ", "").split(",");
    }
}
