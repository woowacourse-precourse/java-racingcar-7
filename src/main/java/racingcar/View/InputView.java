package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String SPLIT_DELIMETER = ",";

    public List<String> readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요");
        return Arrays.stream(Console.readLine().strip().split(SPLIT_DELIMETER))
                .map(String::strip) //앞뒤 공백 제거
                .toList(); // List<String> cars = Arrays.asList("car1","car2","car3")
    }
    public String readRoundCount(){
        System.out.println("시도할 횟수는 몇번인가요?");
        return Console.readLine().strip();
    }
}
