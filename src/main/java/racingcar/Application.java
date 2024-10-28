package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String carNames = getCarNames();
        int moveCount = getMoveCount();
        System.out.println("입력받은 자동차 이름: " + carNames);
        System.out.println("입력받은 이동 횟수: " + moveCount);
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static void validateCarNames(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }


    private static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static class Car {
        private final String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }

        public void move() {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                position++;
            }
        }

        public String getPositionDisplay() {
            return name + " : " + "-".repeat(position);
        }

        public int getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }
    }


}
