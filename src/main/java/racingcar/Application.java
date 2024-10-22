package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringBuilder carNames = new StringBuilder();
        String input;
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분): ");
        while (true) {
            input = Console.readLine(); // 입력 받기

            carNames.append(input);

            // 마지막에 쉼표가 없으면 입력 종료
            if (!input.endsWith(",")) {
                break;
            }
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());
        System.out.println();
        System.out.println("실행 결과");
        // 입력된 자동차 이름 출력
//        String[] carNameArray = carNames.toString().split(",");
//        for (String name : carNameArray) {
//            System.out.print(name.trim() +","); // 트림하여 공백 제거
//        }
    }
}
