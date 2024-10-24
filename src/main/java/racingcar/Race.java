package racingcar;

import static java.util.Comparator.comparing;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Race {
    public static void runRace(List<Car> cars) {
        Integer raceCount = Integer.valueOf(Console.readLine());
        raceStart(raceCount, cars);
    }

    public static void raceStart(Integer raceCount, List<Car> cars) {
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                runCarOnce(car);
            }
            System.out.println();
        }
        printWinners(getWinner(cars));
    }

    public static List<Car> getWinner(List<Car> cars) {
        List<Car> winnerCandidate = cars;
        Car winningCar = cars.stream().max(comparing(Car::getPosition)).orElse(null);
        int maxMove;
        if (winningCar != null) {
            maxMove = winningCar.getPosition();
        } else {
            maxMove = 0;
        }
        List<Car> winningCars = new ArrayList<>();

        while (winningCar != null){
            winningCars.add(winningCar);
            winnerCandidate.remove(winningCar);
            winningCar = winnerCandidate.stream()
                    .filter(car -> maxMove == car.getPosition())
                    .findAny()
                    .orElse(null);
        }
        return winningCars;
    }

    public static void printWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            winners.add(car.getCarName());
        }

        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }

    public static void runCarOnce(Car car){
        if (shouldMove()){
            car.moveForward();
        }
        printOneCarResult(car);
    }

    public static void printOneCarResult(Car car){
        System.out.println(car.getCarName() + " : " + car.getCurrentPositionString());
    }

    public static boolean shouldMove(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

}
