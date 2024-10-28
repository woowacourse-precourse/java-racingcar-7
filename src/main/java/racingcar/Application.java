package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("이름을 입력해주세요: ");
            String names = Console.readLine();
            String[] namesArray = names.split(",");

            Map<String, Integer> carPositions = new HashMap<>();

            int tryCount = inputRaceAttempts(); // 횟수 입력 및 유효성 검사

            for (int i = 0; i < tryCount; i++) {
                int position = 0;
                for (String name : namesArray) {
                    validateCarNames(name); // 이름 유효성 검사
                    int randomNumber = Randoms.pickNumberInRange(0, 9);
                    position = move(randomNumber, position);

                    carPositions.put(name, position);
                }

                for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
                    String carName = entry.getKey();
                    Integer pos = entry.getValue();
                    // 원하는 작업 수행
                    System.out.println(carName + " : " + "-".repeat(pos));
                }
            }

            // 최대값을 가진 키들을 가져옴
            List<String> maxPositionCars = getMaxPositionKeys(carPositions);

            // 결과 출력
            System.out.println("최종 우승자 : " + String.join(", ", maxPositionCars));


        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static List<String> getMaxPositionKeys(Map<String, Integer> map) {
        List<String> maxKeys = new ArrayList<>();
        if (map == null || map.isEmpty()) {
            return maxKeys; // 빈 리스트 반환
        }

        int maxValue = Collections.max(map.values());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxKeys.add(entry.getKey());
            }
        }

        return maxKeys;
    }

    public static int move(int randomNumber, int position) {
        if (randomNumber >= 4) {
            position++;
        }
        return position;
    }

    // 시도할 횟수 입력받기
    public static int inputRaceAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return validateAttempts(input);
    }

    // 입력받은 숫자가 유효한 숫자인지 검사
    private static int validateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateCarNames(String carName) {
        carName = carName.trim();
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}
