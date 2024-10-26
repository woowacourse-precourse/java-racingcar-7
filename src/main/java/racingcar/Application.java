package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
    }

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
}
