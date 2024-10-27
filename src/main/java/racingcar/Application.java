package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carName = Console.readLine();
        List<String> splitName = new ArrayList<>(List.of(carName.split(",")));
        ArrayList<Integer> moveValue = new ArrayList<>();

        for (int i = 0; i < splitName.size(); i++) {

            if (splitName.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5자입니다.");
            }

            int randomNumber = Randoms.pickNumberInRange(0, 9);
            moveValue.add(randomNumber);

            if (moveValue.get(i) >= 4) {
                System.out.println(splitName.get(i) + ":" + "-");
            }
        }
    }
}