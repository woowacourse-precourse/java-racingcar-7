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

        // 값  받아오기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 쉼표를 기준으로 분리
        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

//        // 이름이 올바르게 입력되었음을 확인
//        System.out.println("자동차 이름이 올바르게 입력되었습니다.");

        System.out.println("시도할 횟수를 입력하세요.");
        String attemptsInput = Console.readLine();

        int attempts;
        try {
            attempts = Integer.parseInt(attemptsInput);
            if (attempts < 1) {
                throw new IllegalArgumentException("횟수는 1 이상의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

//        System.out.println("자동차 이름과 시도 횟수가 올바르게 입력되었습니다.");

        // 각 자동차의 이동 거리를 저장할 Map
        Map<String, Integer> carDistances = new HashMap<>();
        for (String car : carNames) {
            carDistances.put(car, 0);
        }

        // 시도 횟수만큼 반복
        for (int i = 0; i < attempts; i++) {
            for (String car : carNames) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if (randomValue >= 4) {
                    carDistances.put(car, carDistances.get(car) + 1);
                }
            }
        }

        // 최종 결과 출력
        for (String car : carNames) {
            System.out.println(car + " : " + "-".repeat(carDistances.get(car)));
        }

        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : carDistances.entrySet()) {
            String car = entry.getKey();
            int distance = entry.getValue();

            if (distance > maxDistance) {
                maxDistance = distance; // 최대 거리 갱신
                winners.clear();        // 이전 우승자 록록 초기화
                winners.add(car);       // 새로운 우승자 추가
            } else if (distance == maxDistance) {
                winners.add(car);       // 공동 우승자 추가
            }
        }

        System.out.println("최종 우승자: " + String.join(", ", winners));

    }
}