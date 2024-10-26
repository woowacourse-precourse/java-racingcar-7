package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List <String> carNames = getCarNames();
        System.out.println("입력한 자동차 이름"  + carNames);
    }

    private static List<String> getCarNames(){
        System.out.println("자동차 이름을 입력해주세요.");
        String inputCarName = Console.readLine();
        return Arrays.asList(inputCarName.split(","));
    }

}
