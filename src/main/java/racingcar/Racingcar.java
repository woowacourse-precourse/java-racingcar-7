package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racingcar {
    public static final String INPUT_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_NUMBER = "시도할 횟수는 몇 회인가요?";
    private final String carName;
    private int position = 0;

    Racingcar(String carName) {
        this.carName = carName;
    }

    public static void init() {
        System.out.println(INPUT_TEXT);
        List<Racingcar> cars = createCars();
        System.out.println(INPUT_NUMBER);
        int numberOfTries = Integer.parseInt(readLine());
        numberException(numberOfTries);
        startRacing(cars, numberOfTries);
    }

    public static List<Racingcar> createCars() {
        String inputText = readLine();
        String[] carNames = inputText.split(",");
        List<Racingcar> cars = new ArrayList<>();

        for (String name : carNames) {
            if (name.length() <= 5) {
                cars.add(new Racingcar(name.trim()));
            } else {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
        isTwoCarValid(cars);
        return cars;
    }

    public static void startRacing(List<Racingcar> cars, int tries) {
        for (int i = 0; i < tries; i++) {
            raceOneRound(cars);
            System.out.println();
        }
        displayWinners(cars);
    }

    public static void raceOneRound(List<Racingcar> cars) {
        for (Racingcar car : cars) {
            int randomNum = getRandomNum();
            car.move(randomNum);
            System.out.println(car.carName + " : " + car.getPositionString());
        }
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position++;
        }
    }

    public String getPositionString() {
        return "-".repeat(position);
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int getPosition() {
        return position;
    }

    public static void displayWinners(List<Racingcar> cars) {
        int maxPosition = cars.stream().mapToInt(Racingcar::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Racingcar car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.carName);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners) + " 입니다.");
    }

    public static void numberException(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void isTwoCarValid(List<Racingcar> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("경주를 위해선 2대 이상의 자동차가 필요합니다.");
        }
    }
}
