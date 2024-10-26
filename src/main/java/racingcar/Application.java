package racingcar;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.*;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = readLine().split(",");
        validateCarNames(carNameList);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(readLine());

        System.out.println(Arrays.toString(carNameList) + " " + count);
    }
    public static void validateCarNames(String[] carNames) {
        for(String carName : carNames) {
            if(carName.length() > 5){
                throw new IllegalArgumentException(ExceptionCode.NAME_LENGTH_EXCEEDED.getMessage() );
            }
        }
    }
}
