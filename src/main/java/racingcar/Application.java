package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Application {

    public static final int NAME_HANDLING_CRITERIA = 5;
    public static final int RANDOM_CONDITIONS = 4;
    public static final String BAR = "-";

    public static void main(String[] args) {
        // 자동차 이름 받기
        // String => String[] 을 위한 split
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.replaceAll(" ", "").split(",");

        // 시도할 횟수 입력 받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        int count = Integer.parseInt(inputCount);

        // 자동차 이름(String[]) => LinkedHashMap에 저장 (value 디폴트 0)
        // 이름 5글자 이내 검수
        Map<String, Integer> carNamesMap = new LinkedHashMap<>();
        for (String carName : carNames) {
            if (carName.length() > NAME_HANDLING_CRITERIA) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이내로 입력해주세요!");
            }
            carNamesMap.put(carName, 0);
        }

        // entrySet 기본 세팅
        Set<Map.Entry<String, Integer>> carNameSet = carNamesMap.entrySet();

        // 자동차 전진,스탑 진행 처리
        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, Integer> carName : carNameSet) {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= RANDOM_CONDITIONS) {
                    carNamesMap.put(carName.getKey(), carName.getValue() + 1);
                }
            }
        }
    }
}
