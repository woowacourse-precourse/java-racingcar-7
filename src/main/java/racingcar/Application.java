package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

public class Application {

    public static final String SPLITTER = ",";
    public static final String GO = "-";
    public static final String FINAL_WINNER = "최종 우승자 : ";
    public static final String BLANK = "";
    public static final String EXECUTE_OUTPUT = "실행 결과";
    public static final String SPACE = " ";
    public static final String COLON = " : ";
    public static final String TRIAL_INPUT = "시도할 횟수는 몇 회인가요?";
    public static final String CARNAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void main(String[] args) {
        System.out.println(CARNAME_INPUT);
        String input = readInput();
        List<RacingCar> cars = splitInput(input);
        System.out.println(TRIAL_INPUT);
        String trialStr = readInput();
        Integer trial = parseTrial(trialStr);

        System.out.println(BLANK);
        System.out.println(EXECUTE_OUTPUT);
        for (int i = 0; i < trial; i++) {
            assignRandomNumber(cars);
            checkRandomNumber(cars);
            printCarInfo(cars);
            System.out.println(BLANK);
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
            throw new IllegalArgumentException("자동차 이름은 4자 이하로 입력해주세요.");
        }
    }

    public static Integer parseTrial(String trialStr) {
        try {
            Integer trial = Integer.parseInt(trialStr);
            return trial;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 잘못 입력하신 것 같아요!");
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
                    .append(COLON)
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
        String notice = FINAL_WINNER + String.join(SPLITTER + SPACE, winnerList);
        System.out.println(notice);
    }
}