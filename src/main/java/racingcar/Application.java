package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputCarNames = Console.readLine();
            Map<String, Integer> carNamesAndPositions = new HashMap<>();
            List<String> carNameList;
            Set<String> carNameSet = new HashSet<>();;

            if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열이거나 공백일 수 없습니다.");
            }

            carNameList = Arrays.asList(inputCarNames.split(","));

            for (String carName : carNameList) {
                carName = carName.trim();

                if (carName.isEmpty()) {
                    throw new IllegalArgumentException("자동차 이름은 빈 문자열이거나 공백일 수 없습니다.");
                }
                if (carName.length() < 1 || carName.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다: " + carName);
                }
                if (!carNameSet.add(carName)) {
                    throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + carName);
                }
                carNamesAndPositions.put(carName, 0);
            }

            System.out.println("시도할 횟수는 몇 회인가요?");
            String inputRacingCount = Console.readLine();

            int racingCount;

            try {
                racingCount = Integer.parseInt(inputRacingCount.trim());
                if (racingCount < 1 || racingCount > 10) {
                    throw new IllegalArgumentException("시도할 횟수는 1 이상 10 이하의 정수여야 합니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("시도할 횟수는 정수로 입력해야 합니다.");
            }



            for (int i = 0; i < racingCount; i++) {
                for (String carName : carNameSet) {
                    int randomValue = Randoms.pickNumberInRange(0, 9);
                    if (randomValue >= 4) {
                        Integer position = carNamesAndPositions.get(carName);
                        carNamesAndPositions.put(carName,++position);
                    }
                }
                for (String carName : carNameSet) {
                    Integer position = carNamesAndPositions.get(carName);
                    String positionDisplay = "-".repeat(position);
                    System.out.println(carName + " : " + positionDisplay);
                }
                System.out.println();
            }

            int maxPosition = Collections.max(carNamesAndPositions.values());
            List<String> winners = new ArrayList<>();

            for (String carName : carNameSet) {
                if (carNamesAndPositions.get(carName) == maxPosition) {
                    winners.add(carName);
                }
            }

            System.out.print("최종 우승자 : ");
            System.out.println(String.join(", ", winners));
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
            throw e;
        }

        Console.close();
    }
}
