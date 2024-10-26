package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Input {

    public static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine(); // 문자열 입력 받기
        String carNames[] = FindError.carNamesError(cars);
        return carNames;
    }

    public static Integer inputTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int tryCount = FindError.tryCountError(input);
        return tryCount;
    }
}
