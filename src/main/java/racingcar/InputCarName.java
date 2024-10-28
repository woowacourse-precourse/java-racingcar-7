package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputCarName {
    public String[] getCarList(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String car = Console.readLine();

        DelimiterName delimiterCar = new DelimiterName();
        String[] carList = car.split(delimiterCar.delimiter);

        for (String carName : carList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + carName);
                }
            }
            return carList;
        }
    }
