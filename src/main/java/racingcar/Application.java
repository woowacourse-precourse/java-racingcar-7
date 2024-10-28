package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String stringNumber = (Console.readLine());

        String[] cars = input.split(",");
        VaildInput(cars, stringNumber);
        int number = Integer.parseInt(stringNumber);

        String[] carScore = new String[cars.length];
        InitializeToSpace(carScore);

        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            StartRaceOnetime(cars, carScore);
            PrintCurrentScore(cars, carScore);
            System.out.println();
        }

        int[] carScoreInt = new int[cars.length];
        StringtoIntArray(carScore, carScoreInt);
        int max = FindLargestValue(carScoreInt);
        int countWinners = CountWinners(carScoreInt, max);
        int[] winners = new int[countWinners];
        StoreWinnerIndex(winners, carScoreInt, max);

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < countWinners; i++) {
            if (i == countWinners - 1) {
                System.out.print(cars[winners[i]]);
            } else {
                System.out.print(cars[winners[i]] + ", ");
            }
        }
    }

    // 1. 잘못된 입력 판단 함수
    private static void VaildInput(String[] cars, String stringNumber) {
        for (int i = 0; i < cars.length; i++) {
            // 5글자 이상이거나, 공백 입력인 경우
            if (cars[i].length() > 5 || cars[i].isEmpty()) {
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        }

        // stringNumber 가 양의 정수가 아니면
        if (!stringNumber.matches("\\d+")) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    // 3. 특정 값을 넣었을 때, 전진할지 멈출지 판단하는 함수
    // 특정 값이 4 이상일 때 전진 (TRUE) . 아니면 스탑 (FALSE)
    private static boolean DecideStopOrNot(int value) {
        return value >= 4;
    }

    // 4. 참여자들의 경주를 1회 시행했을 때의 결과 계산.
    private static void StartRaceOnetime(String[] cars, String[] carScore) {
        for (int i = 0; i < cars.length; i++) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (DecideStopOrNot(random)) {
                carScore[i] += "-";
            }
        }
    }

    // Additionally, 공백으로 문자열 배열 초기화.
    private static void InitializeToSpace(String[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = "";
        }
    }

    // 5. 현재 자동차들의 상황을 출력하는 함수
    private static void PrintCurrentScore(String[] cars, String[] carScore) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " : " + carScore[i]);
        }
    }

    // Additionally, 문자열 배열을 해당 문자열 길이의 정수 배열로 변환하는 함수
    private static void StringtoIntArray(String[] str, int[] ary) {
        for (int i = 0; i < str.length; i++) {
            ary[i] = str[i].length();
        }
    }

    // 6. 우승자를 위치를 저장하는 함수
    // 점수가 같으면 입력한 순서대로 출력
    private static void StoreWinnerIndex(int[] ary, int[] carScoreInt, int maxValue) {
        int index = 0;
        for (int i = 0; i < carScoreInt.length; i++) {
            if (carScoreInt[i] == maxValue) {
                ary[index] = i;
                index++;
            }
        }
    }

    // 6-1. 배열에서 가장 큰 값을 찾는 함수
    private static int FindLargestValue(int[] carScoreInt) {
        int maxValue = carScoreInt[0];
        for (int i = 1; i < carScoreInt.length; i++) {
            maxValue = Math.max(maxValue, carScoreInt[i]);
        }
        return maxValue;
    }

    // 6-2. 우승자의 인원을 반환하는 함수
    private static int CountWinners(int[] carScoreInt, int maxValue) {
        int index = 0;
        for (int i = 0; i < carScoreInt.length; i++) {
            if (carScoreInt[i] == maxValue) {
                index++;
            }
        }
        return index;
    }
}
