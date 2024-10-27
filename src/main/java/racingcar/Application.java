package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static String[] results; // 누적 결과를 저장할 배열

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = readCars(); // 자동차 이름 배열 생성

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptNumber = Integer.parseInt(readLine()); // 입력을 정수로 변환

        // 누적 결과 배열 초기화
        results = new String[cars.length];

        System.out.println("실행 결과");

        // 각 시도마다 결과 출력
        for (int i = 0; i < attemptNumber; i++) {
            simulateRace(cars); // 경주 시뮬레이션
            printResults(cars); // 결과 출력
        }

        // 최종 우승자 결정
        determineWinner(cars);
    }

    private static String[] readCars() {
        String carName = readLine();
        return java.util.Arrays.stream(carName.split(","))
                .map(String::trim)
                .toArray(String[]::new);
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
        System.out.println(); // 줄바꿈
    }

    private static void determineWinner(String[] cars) {
        int maxDashes = 0;
        StringBuilder winners = new StringBuilder();

        for (int j = 0; j < cars.length; j++) {
            int dashCount = (results[j] != null) ? results[j].length() - results[j].replace("-", "").length() : 0; // "-"의 개수 계산
            if (dashCount > maxDashes) {
                maxDashes = dashCount; // 최대 "-" 개수 업데이트
                winners.setLength(0); // 기존 우승자 초기화
                winners.append(cars[j]); // 새로운 우승자 추가
            } else if (dashCount == maxDashes) {
                if (winners.length() > 0) {
                    winners.append(", "); // 쉼표 추가
                }
                winners.append(cars[j]); // 동점자 추가
            }
        }

        System.out.println("최종 우승자: " + winners.toString());
    }
}
