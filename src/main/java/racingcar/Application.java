package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

//- **경주할 자동차 이름 입력받기**
//        - 경주할 자동차 이름을 입력하세요
//        - 이름은 쉼표(,) 기준으로 구분
//        - 각 이름이 5자 이하인지 확인하고 아닐경우 **IllegalArgumentException** 발생시킨 후 애플리케이션 종료
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> cars = new ArrayList<>(Arrays.asList(readLine().split(",")));
        for (String car : cars){
            if (car.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력 해야합니다.");
            }
        }
    }
}
