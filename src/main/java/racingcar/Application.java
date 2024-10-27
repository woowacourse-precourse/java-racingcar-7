package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("Enter the name of the car you want to race.");
        String[] nameArr = Console.readLine().split(",");

        ArrayList<Car> carArr = new ArrayList<>();
        for (int i = 0; i < nameArr.length; i++) {
            Car car = new Car(nameArr[i]);
            carArr.add(car);
        }

        System.out.println("Enter how many raced to race");
        int raceCount = Integer.parseInt(Console.readLine());

        for (int i = 0; i < raceCount; i++) {
            for (Car car : carArr) {
                car.randomRacing();
                Game.printCars(car);
            }
            System.out.println();
        }
        Game.printWinner(Game.findWinner(carArr));


    }
}
