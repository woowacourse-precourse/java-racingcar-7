package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputCarName {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String car = Console.readLine();

        DelimiterName delimiterCar = new DelimiterName();
        String[] CarList = car.split(delimiterCar.delimiter);
    }
}
