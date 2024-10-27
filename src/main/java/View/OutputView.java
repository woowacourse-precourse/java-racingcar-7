package View;

import domain.Car;
import domain.Cars;
import domain.FindWinningCar;

import java.util.List;

public class OutputView {

    public static void resultOfCarRacing() {
        System.out.println("실행 결과");
    }

    private static String getCarsLocation(final int carLocation) {
        final StringBuilder carsLocation = new StringBuilder();
        for (int i = 0; i < carLocation; i++) {
            carsLocation.append("-");
        }
        return carsLocation.toString();
    }

    public static void resultOfEveryRace(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format("%s : %s", car.getCarName(), getCarsLocation(car.getCarLocation())));
        }
        System.out.println();
    }

    public static void resultOfFinalWinner(Cars cars) {
        FindWinningCar findWinningCar = new FindWinningCar(cars.getCars());
        List<String> winningCars = findWinningCar.getWinningCars();

        System.out.println("최종 우승자 : " + String.join(", ", winningCars));
    }
}
