package util;

import static util.Extractor.extractRaceStatus;

import java.util.ArrayList;
import repository.CarRepository;

public class Output {

    public static void printRaceStatus(int repeatCount) {
        for (Car car : CarRepository.cars) {
            String carName = car.getName();
            int forwardCount = car.getForwardCount(repeatCount);
            String raceStatus = extractRaceStatus(forwardCount);
            System.out.println(carName + " : " + raceStatus);
        }
        System.out.println();
    }

    public static void printRacingResult() {
        System.out.println("실행 결과");
        for (int i = 1; i <= CarRepository.repeatCount; i++) {
            Output.printRaceStatus(i);
        }
    }

    public static void printWinningCars() {
        ArrayList<String> winningCars = Extractor.extractWinningCarList();
        String result = String.join(", ", winningCars);
        System.out.println("최종 우승자 : " + result);
    }
}
