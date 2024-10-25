package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return carNames;
    }

    public static int getTryNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        return tryNumber;
    }
}
