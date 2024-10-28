package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        String[] cars = nameInput.split(",");
        ValidateCarNames(cars);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptInt = (Console.readLine());
        int attemptCount = ValidateAttemptCount(attemptInt);// 시도 횟수 검증
        // 자동차 경주 시작
        String[] carPosition = carRacing(cars, attemptCount);

        //우승자 판별 및 결과출력
        announceWinners(cars, carPosition);
    }

    private static void ValidateCarNames(String[] carNames) {
        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int ValidateAttemptCount(String attemptInput) {
        try {
            int attemptCount = Integer.parseInt(attemptInput);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException();
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 자동차 경주 시작
    private static String[] carRacing(String[] cars, int attemptCount) {
        String[] carPosition = new String[cars.length];
        for (int i = 0; i < cars.length; i++) {
            carPosition[i] = ""; // 빈문자열로 초기화
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            for (int j = 0; j < cars.length; j++) {
                int randomInt = Randoms.pickNumberInRange(0, 9);
                // 4이상일 때 전진
                if (randomInt >= 4) {
                    carPosition[j] += "-";
                }
                System.out.println(cars[j] + " : " + carPosition[j]);
            }
            System.out.println(); // 각 시도마다 줄바꿈
        }
        return carPosition;
    }

    private static void announceWinners(String[] cars, String[] carPosition) {
        int maxLength = 0;
        // 가장 긴 이동거리 구하기
        for (String position : carPosition) {
            maxLength = Math.max(maxLength, position.length());
        }

        //우승자 수 세기
        int winnersCount = 0;
        for (String position : carPosition) {
            if (maxLength == position.length()) {
                winnersCount++;
            }
        }

        //우승자 찾기
        String[] winnersList = new String[winnersCount];
        int index = 0;
        for (int i = 0; i < cars.length; i++) {
            if (carPosition[i].length() == maxLength) {
                winnersList[index] = cars[i];
                index++;
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winnersList));
    }
}


