package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public List<String> getCarNames(){
        System.out.println("========== 자동차 경주 게임 ==========");
        System.out.println();
        System.out.print("경주할 자동차 이름을 입력하세요. : ");

        String inputCarNames = Console.readLine();
        String[] carNamesArray = inputCarNames.split(",");

        List<String> carNames = new ArrayList<>();
        for (String name: carNamesArray){
            carNames.add(name.trim());
        }
        System.out.println();
        return carNames;
    }

    public int getAttempCount(){
        System.out.print("시도할 횟수를 입력하세요. : ");

        String count = Console.readLine();
        int attemptCount = Integer.parseInt(count);

        System.out.println();
        return attemptCount;
    }

}

