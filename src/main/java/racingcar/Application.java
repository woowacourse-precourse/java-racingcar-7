package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Car> carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        try {
            String[] carInput = Console.readLine().split(",");

            for (String s : carInput) {
                if (s.length() > 5)
                    throw new IllegalArgumentException(ErrorMessage.CAR_NAME.toString());
                carList.add(new Car(s));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.toString());
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryInput = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT.toString());
        }


    }
}
