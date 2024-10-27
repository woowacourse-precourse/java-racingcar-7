package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static String[] results; // 누적 결과를 저장할 배열

    public static void main(String[] args) {
        String[] cars = initializeRace(); // 경주 초기화
        int attemptNumber = getAttemptNumber(); // 시도 횟수 입력
        results = new String[cars.length]; // 누적 결과 배열 초기화

        System.out.println("실행 결과");
        runRace(cars, attemptNumber); // 경주 실행
        determineWinner(cars); // 최종 우승자 결정
    }

    private static String[] initializeRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = readLine();
        return java.util.Arrays.stream(carName.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private static int getAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(readLine()); // 입력을 정수로 변환
    }

    private static void runRace(String[] cars, int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            simulateRace(cars); // 경주 시뮬레이션
            printResults(cars); // 결과 출력
        }
    }

    private static void simulateRace(String[] cars) {
        for (int j = 0; j < cars.length; j++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                results[j] = (results[j] == null ? "" : results[j]) + "-"; // 결과 누적
            }
        }
    }

    private static void printResults(String[] cars) {
        for (int j = 0; j < cars.length; j++) {
            System.out.print(cars[j] + ": " + (results[j] != null ? results[j] : "") + " "); // 자동차 이름과 누적 결과 출력
            System.out.println();
        }
        System.out.println();
    }

    private static void determineWinner(String[] cars) {
        int maxDashes = 0;
        StringBuilder winners = new StringBuilder();

        for (int j = 0; j < cars.length; j++) {
            int dashCount = countDashes(results[j]); // "-"의 개수 계산
            winners = updateWinners(cars[j], dashCount, maxDashes, winners); // 우승자 업데이트
            maxDashes = Math.max(maxDashes, dashCount); // 최대 "-" 개수 업데이트
        }

        System.out.println("최종 우승자: " + winners.toString());
    }

    private static int countDashes(String result) {
        return (result != null) ? result.length() - result.replace("-", "").length() : 0; // "-" 개수 반환
    }

    private static StringBuilder updateWinners(String car, int dashCount, int maxDashes, StringBuilder winners) {
        if (dashCount > maxDashes) {
            winners.setLength(0); // 기존 우승자 초기화
            winners.append(car); // 새로운 우승자 추가
        } else if (dashCount == maxDashes) {
            if (winners.length() > 0) {
                winners.append(", ");
            }
            winners.append(car);
        }
        return winners;
    }
}
