package racingcar;

import java.util.ArrayList;
import java.util.Comparator;

public class Challenge {

    private ArrayList<Car> partCars;

    public Challenge() {
        partCars = new ArrayList<>();
    }

    public void printStep() {
        for(Car car : partCars) {
            System.out.print(car.getCarName() + " : ");
            for(int i=0; i<car.getDistance(); i++)
                System.out.print("-");
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner() {
        partCars.sort(Comparator.comparingInt(Car::getDistance).reversed());
        int tmp = partCars.get(0).getDistance(); // 가장 앞에 있는(가장 큰 distance)
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : partCars) {
            if(car.getDistance() == tmp) {
                winners.add(car.getCarName());
            }
        }

        System.out.println(String.join(", ", winners));
    }
}
