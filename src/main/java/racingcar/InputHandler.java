package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputHandler {
    public List<String> getCarNames(){
        List<String> carNames = new ArrayList<>();
        String inputCarNames;

        while (true) {
            System.out.print("경주할 자동차 이름을 입력하세요.(완료: 0) : ");
            inputCarNames = Console.readLine().trim();

            if (inputCarNames.equals("0")) {
                break;
            }

            String[] names = inputCarNames.split(",");
            for (String name : names) {
                carNames.add(name.trim());
            }
        }
        System.out.println("입력된 자동차 이름: " + carNames);
        return carNames;
    }

    public int getAttempCount(){
        System.out.print("시도할 횟수를 입력하세요. : ");
        String count = Console.readLine();
        return Integer.parseInt(count);
    }

}

