package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Race {
    public void runRace() {
        String racingCarsName = inputCarName();
        validateCarEmpty(racingCarsName);

        int raceRound = inputRaceRound();
        validateRaceRound(raceRound);

        List<Car> racingCars = createCarClassList(racingCarsName);

        startRaceRound(racingCars, raceRound);

        int maxScore = findMaxScore(racingCars);
        printWinner(racingCars, maxScore);
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine();
    }

    public int inputRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public List<Car> createCarClassList(String str) {
        List<String> carsList = Arrays.asList(str.split(","));

        List<Car> racingCars = new ArrayList<>();
        for (String name : carsList) {
            validateNameLength(name);
            racingCars.add(new Car(name));
        }
        return racingCars;
    }

    public void startRaceRound(List<Car> racingCars, int raceRound) {
        System.out.println("\n실행 결과");
        for(int i = 0; i < raceRound; i++) {
            playRace (racingCars);
        }
    }

    public void playRace(List<Car> racingCars) {
        for(Car car : racingCars) {
            getRandomNumberPrintResult(car);
        }
        System.out.println();
    }

    public void getRandomNumberPrintResult(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.score ++;
        }
        System.out.println(car.name+" : " + "-".repeat(car.score));
    }

    public int findMaxScore(List<Car> racingCars) {
        int maxScore = racingCars.stream()
                .mapToInt(car -> car.score)
                .max()
                .orElse(0);
        return maxScore;
    }

    public void printWinner(List<Car> racingCars, int maxScore) {
        List<String> winners = racingCars.stream()
                .filter(car -> car.score == maxScore)
                .map(car -> car.name)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void validateCarEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("input nothing");
        }
    }

    public void validateRaceRound(Integer num) {
        if (num <= 0) {
            throw new IllegalArgumentException("wrong input");
        }
    }

    public void validateNameLength(String name) {
        if (name.length() > 5 ) {
            throw new IllegalArgumentException("wrong input");
        }
    }
}
