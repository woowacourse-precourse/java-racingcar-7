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
        StartRaceOnetime(cars, carScore);
        System.out.println(cars[0]+":"+carScore[0]);
        System.out.println(cars[1]+":"+carScore[1]);
    }

    // 1. 잘못된 입력 판단 함수
    private static void VaildInput(String[] cars, String stringNumber) {
        for(int i = 0; i < cars.length; i++) {
            // 5글자 이상이거나, 공백 입력인 경우
            if(cars[i].length() > 5 || cars[i].isEmpty()) {
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        }

        // stringNumber 가 양의 정수가 아니면
        if(!stringNumber.matches("\\d+")) {
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
        for(int i = 0; i < cars.length; i++) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (DecideStopOrNot(random)) {
                carScore[i] += "-";
            }
        }
    }


}
