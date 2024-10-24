package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carString = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryString = Console.readLine();
        System.out.println("\n실행 결과");

        String[] carName = carString.split(",");
        int tryCount = Integer.parseInt(tryString);

        List<Car> carList = new ArrayList<>();

        for (String name : carName) {
            carList.add(new Car(name));
        }

        for (int i = 0; i < tryCount; i++) {
            for (Car car : carList) {
                car.move();
                System.out.println(car.getPositionString());
            }
            System.out.println();
        }
    }
}
