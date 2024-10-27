package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.*;
import java.util.stream.Stream;

public class Application {

    public static final String SPLITTER = ",";
    public static final String GO = "-";
    public static final String FINAL_WINNER = "최종 우승자 : ";

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readInput();
        List<RacingCar> cars = splitInput(input);
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialStr = readInput();
        Integer trial = parseTrial(trialStr);

        for (int i = 0; i < trial; i++) {
            assignRandomNumber(cars);
            checkRandomNumber(cars);
            printCarInfo(cars);
            System.out.println("");
        }

        int winPosition = getWinPosition(cars);
        List<String> winners = getWinners(cars, winPosition);
        printWinners(winners);
    }

    public static String readInput() {
        return Console.readLine();
    }

    public static List<RacingCar> splitInput(String input) {
        String[] racingCars = input.split(SPLITTER);
        List<RacingCar> racingCarList = new ArrayList<>();

        Arrays.stream(racingCars)
                .forEach(name -> {
                    checkCarName(name);
                    racingCarList.add(new RacingCar(name.trim()));
                });

        Set<String> hashCars = new HashSet<>(Arrays.asList(racingCars));
        if (hashCars.size() != racingCarList.size()) {
            throw new IllegalArgumentException("동일한 이름을 가진 차종을 입력하실 수 없습니다.");
        }

        return racingCarList;
    }

    public static void checkCarName(String carName) {
        if (carName.isEmpty() || carName == null || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer parseTrial(String trialStr) {
        try {
            Integer trial = Integer.parseInt(trialStr);
            return trial;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void assignRandomNumber(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            racingCar.randomNumbers.add(getRandomNumber());
        }
    }

    public static void checkRandomNumber(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int pos = (int) racingCar.randomNumbers.stream()
                    .filter(i -> i >= 4)
                    .count();
            racingCar.position = pos;
        }
    }

    public static void printCarInfo(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            StringBuilder carInfo = new StringBuilder();
            carInfo.append(racingCar.name)
                    .append(" : ")
                    .append(GO.repeat(racingCar.position));
            System.out.println(carInfo);
        }
    }

    public static Integer getWinPosition(List<RacingCar> racingCarList) {
        return racingCarList.stream()
                .mapToInt(racingCar -> racingCar.position)
                .max()
                .orElse(0);
    }

    public static List<String> getWinners(List<RacingCar> racingCarList, int maxPosition) {
        List<String> winnerList = new ArrayList<>();

        racingCarList.stream()
                .filter(racingCar -> racingCar.position == maxPosition)
                .forEach(racingCar -> winnerList.add(racingCar.name));

        return winnerList;
    }

    public static void printWinners(List<String> winnerList) {
        String notice = FINAL_WINNER + String.join(SPLITTER + " ", winnerList);
        System.out.println(notice);
    }
}