package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //경주 게임 시작
        String[] carNames = inputCarNames();       // 자동차 이름 입력하기
        int trialCount = inputTrialCount();        // 이동을 시도할 횟수 입력하기
        String[] raceResults = performRace(carNames, trialCount); // 레이스 수행 후 결과 저장
        announceWinners(carNames, raceResults);    // 최종 우승자 출력하기
    }

    // 자동차 이름 입력하기
    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();

        // 쉼표 구분자를 이용하여 입력한 자동차를 구별하고 배열에 넣기
        if (carNameInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        String[] carNames = carNameInput.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return carNames;
    }

    // 이동을 시도할 횟수 입력하기
    private static int inputTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int trialCount = Integer.parseInt(input);
            if (trialCount <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
            }
            return trialCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    // 레이스 수행 후 결과 저장
    private static String[] performRace(String[] carNames, int trialCount) {
        // 각 자동차의 전진 결과를 저장할 배열 초기화
        String[] raceResults = new String[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            raceResults[i] = "";
        }

        // 횟수만큼 시도할 때마다 전진한 횟수 출력하기
        for (int j = 0; j < trialCount; j++) {
            for (int i = 0; i < carNames.length; i++) {
                // 0~9 사이에 무작위 값 생성하기
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    raceResults[i] += "-";    // 무작위 값이 4 이상일 경우 전진하기
                }
                System.out.println(carNames[i] + " : " + raceResults[i]);
            }
            System.out.println();
        }
        return raceResults;
    }

    // 최종 우승자 출력하기
    private static void announceWinners(String[] carNames, String[] raceResults) {
        int maxDistance = calculateMaxDistance(raceResults); // 경주할 자동차 중 전진한 최대값 구하기
        List<String> winners = findWinners(carNames, raceResults, maxDistance); // 최대값을 가진 자동차를 최종 우승자로 선정하기

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    // 경주할 자동차 중 전진한 최대값 구하기
    private static int calculateMaxDistance(String[] raceResults) {
        int maxDistance = 0;
        for (String result : raceResults) {
            maxDistance = Math.max(maxDistance, result.length());
        }
        return maxDistance;
    }

    // 최대값을 가진 자동차를 최종 우승자로 선정하기
    private static List<String> findWinners(String[] carNames, String[] raceResults, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (raceResults[i].length() == maxDistance) {
                winners.add(carNames[i]);
            }
        }
        return winners;
    }
}
