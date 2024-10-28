package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            // 자동차 이름 입력
            List<String> carNames = getCarNames();
            // 시도 횟수 입력
            int attempts = getAttempts();
            // 입력 값 기준으로 게임 초기 세팅
            Map<String, Integer> carPositions = initializeCarPositions(carNames);

            // 경주 게임 시작
            runRace(carNames, carPositions, attempts);
            // 우승자 안내 문구 출력
            announceWinners(carNames, carPositions);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    // 자동차 이름 입력
    // 입력 값 검사
    private static void validateCarNames(String input) {
        if (!input.matches("(\\b\\w{1,5}\\b)(,\\b\\w{1,5}\\b)*")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        // 정규 표현식 검사
        validateCarNames(input); // 검사 메서드 호출

        String[] nameArray = input.split(",");
        return new ArrayList<>(List.of(nameArray)); // 배열을 리스트로 변환
    }


    // 시도 횟수 입력
    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return validateAttempts(input);
    }

    private static int validateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    // 입력 값 기준으로 게임 초기 세팅
    private static Map<String, Integer> initializeCarPositions(List<String> names) {
        Map<String, Integer> carPositions = new HashMap<>();
        for (String name : names) {
            carPositions.put(name, 0);
        }
        return carPositions;
    }


    // 경주 게임 시작
    private static void runRace(List<String> names, Map<String, Integer> carPositions, int attempts) {
        for (int i = 0; i < attempts; i++) {
            // 각 자동차에 대해 이동 여부 결정
            for (String name : names) {
                int picked = Randoms.pickNumberInRange(0, 9);
                if (picked >= 4) {
                    // 이동 거리를 1 증가
                    carPositions.put(name, carPositions.get(name) + 1);
                }
            }

            // 차수별 실행 결과 출력
            printPositions(names, carPositions);
        }
    }

    // 차수별 실행 결과 출력
    private static void printPositions(List<String> names, Map<String, Integer> carPositions) {
        for (String name : names) {
            int position = carPositions.get(name);
            System.out.print(name + " : ");
            System.out.println("-".repeat(position));
        }
        System.out.println();
    }


    // 우승자 안내 문구 출력
    private static void announceWinners(List<String> names, Map<String, Integer> carPositions) {
        int maxPosition = carPositions.values().stream().max(Integer::compare).orElse(0);
        StringBuilder winners = new StringBuilder();
        for (String name : names) {
            if (carPositions.get(name) == maxPosition) {
                winners.append(name).append(", ");
            }
        }

        System.out.println("최종 우승자 : " + winners.substring(0, winners.length() - 2));
    }
}
