package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String[] carNames = input.split(",");
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

        int max = 0;
        for (Car car : cars) {
            if (car.getLocation() > max) {
                max = car.getLocation();
            }
        }
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Car car : cars) {
            if(car.getLocation() ==max ){
                stringJoiner.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + stringJoiner.toString());
    }



}

