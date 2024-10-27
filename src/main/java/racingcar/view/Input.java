package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public String getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        isValidCarName(splitCarName(input));
        return input;
    }

    public int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Integer.parseInt(Console.readLine());
        return input;
    }

    //자동차 이름 쉼표로 구분
    public List<String> splitCarName(String carInput) {
        List<String> carNames = Arrays.asList(carInput.split(","));
        return carNames;
    }

    //자동차 이름 유효성 검사 : 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    public boolean isValidCarName(List<String> carName) {
        try {
            for (String name : carName) {
                if (name.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    //시도할 횟수 유효성 검사 1이상의 숫자여야 함
    public boolean isValidRound(int round) {
        if (round < 1) {
            System.out.println("시도 횟수는 1 이상의 숫자여야 합니다.");
            return false;
        }
        return true;
    }
}
