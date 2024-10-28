package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNamesInput = Console.readLine();
            String[] carNames = validateCarNames(carNamesInput);
            
            // 자동차 이동
            moveCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static String[] validateCarNames(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    static void moveCars(String[] carNames) {
        for (String car : carNames) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                System.out.println(car + "가 전진합니다.");
            } else {
                System.out.println(car + "가 멈춥니다.");
            }
        }
    }
}
