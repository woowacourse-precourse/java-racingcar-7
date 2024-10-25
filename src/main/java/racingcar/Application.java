package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.validator.Validator;

public class Application {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();

        String inputCarNames = Console.readLine();
        int attempts = Integer.parseInt(Console.readLine());
        Console.close();

        String[] carNames = inputCarNames.split(",");

        Map<String, String> carMoveMap = new HashMap<>();
        for(String carName : carNames) { //carName의 앞 뒤에 공백이 있을 경우 고려
            Boolean carNameLengthValidate = validator.carNameLengthValidate(carName);
            if (carNameLengthValidate) {
                carMoveMap.put(carName, "");
            } else {
                throw new IllegalArgumentException("레이싱카의 이름의 길이는 5를 넘을 수 없습니다.");
            }
        }


        int trial = 0;
        int randomNum = 0;
        while (trial <= attempts) {
            trial++;
            for (String carName: carNames) {
                randomNum = Randoms.pickNumberInRange(0, 9);
                if (randomNum >= MOVING_FORWARD) {
                    carMoveMap.put(carName, carMoveMap.get(carName) + '-');
                } else if (randomNum <= STOP) {
                    continue;
                }
            }
            for (Entry<String, String> items : carMoveMap.entrySet()) {
                String car = items.getKey();
                String move = items.getValue();
                System.out.println(car + " : " + move);
            }
        }

        int winnerPosition = 0;
        ArrayList<String> winners = new ArrayList<>();
        for (Entry<String, String> items : carMoveMap.entrySet()) {
            int position = items.getValue().length();

            if (position > winnerPosition) {
                winnerPosition = position;
                winners.clear();
                winners.add(items.getKey());
            } else if (position == winnerPosition) {
                winners.add(items.getKey());
            } else {
                continue;
            }
        }


        String winnerPrint = "최종 우승자 : " + String.join(",", winners);
        System.out.println("winnerPrint = " + winnerPrint);
    }
}
