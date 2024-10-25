package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final String SPLITTER = ",";

    public static void main(String[] args) {
        String input = readInput();
        List<RacingCar> cars = splitInput(input);
        String trialStr = readInput();
        Integer trial = parseTrial(trialStr);

        for(int i = 0; i < trial; i++){
            assignRandomNumber(cars);
            checkRandomNumber(cars);
            printCarInfo(cars);
            System.out.println("");
        }

        int winPosition = getWinPosition(cars);
        List<String> winners = getWinners(cars, winPosition);
        printWinners(winners);
    }

    public static String readInput(){
        return Console.readLine();
    }

    //자동차 이름 List에 집어넣기
    public static List<RacingCar> splitInput(String input) {
        String[] racingCars = input.split(SPLITTER);
        //기능 분리하기
        List<RacingCar> racingCarList = new ArrayList<>();
        //int numOfCars = racingCars.length;
        for (String carName : racingCars) {
            if (carName.isEmpty() || carName == null || carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            RacingCar racingCar = new RacingCar(carName);
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    //시도 횟수 입력 받기
    public static Integer parseTrial(String trialStr) {
        try {
            Integer trial = Integer.parseInt(trialStr);
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
            racingCar.randomNumbers.add(getRandomNumber());
        }
    }

    public static void checkRandomNumber(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int pos = 0;
            for (int i = 0; i < racingCar.randomNumbers.size(); i++) {
                if (racingCar.randomNumbers.get(i) >= 4) pos++;
            }
            racingCar.position = pos;
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
        for (RacingCar racingCar : racingCarList) {
            if (racingCar.position == maxPosition) {
                winnerList.add(racingCar.name);
            }
        }
        return winnerList;
    }

    public static void printWinners(List<String> winnerList) {
        String notice = "최종 우승자 : ";
        if (winnerList.size() == 1) {
            notice += winnerList.get(0);
            System.out.println(notice);
            return;
        } else if (winnerList.size() > 1) {
            for (int i = 0; i < winnerList.size(); i++) {
                notice += winnerList.get(i);
                notice += SPLITTER;
                notice += " ";
            }
            notice = notice.substring(0, notice.length() - 2);
            System.out.println(notice);
        }
    }
}
