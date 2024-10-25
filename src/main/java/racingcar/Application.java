package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        List<Car> cars = new ArrayList<>();
        List<String> winners = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            if(carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하로 입력해주세요.");
            }
            cars.add(new Car(carName));
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        inputString = Console.readLine();
        System.out.println("\n실행 결과");
        int playTime = Integer.parseInt(inputString);
        int maxMoveCount = 0;
        while (playTime-- > 0) {
            for (Car car : cars) {
                int value = Randoms.pickNumberInRange(0, 9);
                car.move(value);
                maxMoveCount = Math.max(maxMoveCount, car.moveCount);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Car car : cars) {
                stringBuilder.append(car).append("\n");
            }
            System.out.println(stringBuilder);
        }
        for (Car car : cars) {
            if (car.moveCount == maxMoveCount) {
                winners.add(car.name);
            }
        }
        String result = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s", result);
    }

    static class Car {
        String name;
        int moveCount = 0;

        Car(String name) {
            this.name = name;
        }

        void move(int value) {
            if (value >= 4) {
                moveCount++;
            }
        }

        @Override
        public String toString() {
            return name + " : " + "-".repeat(moveCount);
        }
    }
}
