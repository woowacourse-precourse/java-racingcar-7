package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

//- **몇 번의 이동을 할 지 사용자에게 입력받기**
//        - 시도할 횟수는 몇 회인가요?
//        - 10번 이하로 가정하고 입력받기
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

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber = Integer.parseInt(readLine());
        if (tryNumber > 10){
            throw new IllegalArgumentException("시도하는 횟수가 너무 많습니다. 10회 이하로 설정해주세요");
        }
    }
}
