package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final String SPLITTER = ",";

    public static void main(String[] args) {
        List<RacingCar> cars = getCarInput();
        Integer trial = getTrial();

    }

    //경주할 자동차 입력 받기
    public static List<RacingCar> getCarInput() {
        String input = Console.readLine();
        String[] racingCars = input.split(SPLITTER);
        //기능 분리하기
        List<RacingCar> racingCarList = new ArrayList<>();
        int numOfCars = racingCars.length;
        for (String carName : racingCars) {
            if (carName.isEmpty() || carName == null || carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            RacingCar racingCar = new RacingCar(carName, numOfCars);
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    //시도 횟수 입력 받기
    public static Integer getTrial() {
        String input = Console.readLine();
        Integer trial = 0;
        try {
            trial = Integer.parseInt(input);
            return trial;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer getCarNumber(List<RacingCar> racingCarList) {
        return racingCarList.size();
    }

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void assignRandomNumber(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            for (int i = 0; i < racingCar.randomNumbers.size(); i++) {
                racingCar.randomNumbers.set(i, getRandomNumber());
            }
        }
    }

    public static void checkRandomNumber(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            for (int i = 0; i < racingCar.randomNumbers.size(); i++) {
                if (racingCar.randomNumbers.get(i) >= 4) racingCar.position += 1;
            }
        }
    }

    public static void printCarInfo(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            String carInfo = "";
            carInfo += racingCar.name;
            carInfo += " : ";
            for (int i = 0; i < racingCar.position; i++) {
                carInfo += "-";
            }
            System.out.println(carInfo);
        }
    }

    public static Integer getWinPosition(List<RacingCar> racingCarList) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCarList) {
            if (racingCar.position > maxPosition) maxPosition = racingCar.position;
        }
        return maxPosition;
    }

    public static List<String> getWinners(List<RacingCar> racingCarList, int maxPosition) {
        List<String> winnerList = new ArrayList<>();
        for(RacingCar racingCar : racingCarList) {
            if(racingCar.position == maxPosition) {
                winnerList.add(racingCar.name);
            }
        }
        return winnerList;
    }
}
