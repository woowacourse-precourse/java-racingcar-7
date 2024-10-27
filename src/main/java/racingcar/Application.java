package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] carNameList = input.split(",");

        for(String car : carNameList) {
            if(car.isEmpty() || car.length() >5) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            int roundNumber = Integer.parseInt(Console.readLine());

            if(roundNumber < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }
}
