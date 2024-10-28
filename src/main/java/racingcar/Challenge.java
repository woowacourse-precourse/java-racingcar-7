package racingcar;

import java.util.ArrayList;
import java.util.Comparator;

public class Challenge {

    private ArrayList<Car> partCars;
    private ArrayList<String> winners;
    private int totalStep;

    public Challenge(int totalStep) {
        partCars = new ArrayList<>();
        winners = new ArrayList<>();
        this.totalStep = totalStep;
    }

    public void addCar(Car car) {
        partCars.add(car);
    }

    public void runChallenge() {
        for (int i = 0; i < totalStep; i++) {
            for (Car tmpcar : partCars) {
                tmpcar.moveDistance();
            }
            printStep();
        }

        makeWinnerList();
        printWinner();
    }

    private void makeWinnerList() {
        partCars.sort(Comparator.comparingInt(Car::getDistance).reversed());
        int tmp = partCars.get(0).getDistance(); // 가장 앞에 있는(가장 큰 distance)

        for (Car car : partCars) {
            if (car.getDistance() == tmp) {
                winners.add(car.getCarName());
            }
        }
    }

    private void printStep() {
        for (Car car : partCars) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printWinner() {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
