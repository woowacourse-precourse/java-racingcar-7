package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputCarNames = Console.readLine();
        String[] carNames = validateCarNames(inputCarNames);

        System.out.println("시도할 횟수는 몇 회인가요?");

        String inputCount = Console.readLine();
        int count = validateCount(inputCount);

        Map<String, StringBuilder> result = new HashMap<>();
        for(String carName : carNames) {
            result.put(carName, new StringBuilder());
        }

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for(String carName : carNames) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    result.put(carName, result.get(carName).append("-"));
                }
            }
            for (String carName : carNames) {
                System.out.println(carName + " : " + result.get(carName));
            }
            System.out.println();
        }

        int maxMoveCount = result.values().stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);

        List<String> winners = result.entrySet().stream()
                .filter(entry -> entry.getValue().length() == maxMoveCount)
                .map(Map.Entry::getKey)
                .toList();

        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public static String[] validateCarNames(String inputCarNames) {
        if (inputCarNames == null) {
            throw new IllegalArgumentException("자동차 이름은 null이어서는 안 됩니다.");
        }
        // 자동차 이름이 한 자 이상인 경우의 조건을 판단하는 코드가 분리되어 있음
        if (inputCarNames.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
        String[] carNames = inputCarNames.split(",");
        if (carNames.length > 100) {
            throw new IllegalArgumentException("자동차 이름은 100개 이하로 입력되어야 합니다.");
        }
        for(String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
            }
            if (isAsciiCode(carName)) {
                throw new IllegalArgumentException("자동차 이름은 아스키 코드여야 합니다.");
            }
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.");
            }
        }
        // 순서가 여기 있어야 논리적으로 맞음 -> 분리해야 할까?
        if(isSameNameContained(carNames)) {
            throw new IllegalArgumentException("자동차 이름이 중복되어서는 안 됩니다.");
        }
        return carNames;
    }

    public static int validateCount(String inputCount) {
        int count;
        try {
            count = Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
        if (count > 100) {
            throw new IllegalArgumentException("시도 횟수는 100이하여야 합니다.");
        }
        return count;
    }

    private static boolean isAsciiCode(String carName) {
        char[] chars = carName.toCharArray();
        for(char c : chars) {
            if (c > 127) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameNameContained(String[] carNames) {
        Set<String> carNameCheckSet = new HashSet<>();
        for(String carName : carNames) {
            if(!carNameCheckSet.add(carName)) {
                return true;
            }
        }
        return false;
    }
}
