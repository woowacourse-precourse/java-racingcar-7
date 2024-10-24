package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        List<Car> cars = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            cars.add(new Car(stringTokenizer.nextToken()));
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        inputString = Console.readLine();
        int playTime = Integer.parseInt(inputString);
    }

    static class Car {
        String name;
        int moveCount = 0;

        Car(String name) {
            this.name = name;
        }

        void move(int value) {
            if (value >= 4) {
                this.moveCount++;
            }
        }
    }
}
