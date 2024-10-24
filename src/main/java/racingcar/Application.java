package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String[] carNames = input.split(",");
        /*
        입력 예외 처리해야함
        이름은 5자 이내
        구분자는 ,(쉼표) 만
         */
        String inputNum = Console.readLine();
        int count = Integer.parseInt(inputNum);


        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        while (count > 0) {
            for (Car car : cars) {
                car.move();
            }

            for (Car car : cars) {
                System.out.print(car.getName() + " : ");
                for (int i = 0; i < car.getLocation(); i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
            count --;
        }
        }

}

