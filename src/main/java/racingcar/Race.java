package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Race {
    private final ArrayList<Car> cars = new ArrayList<>();
    private int winnerDistance = 0;

    public Race(final String firstInput, final String secondInput) {
        String[] nameList = firstInput.split(",");
        for (String name : nameList) {
            validateName(name);
        }

        final int numberOfCar = nameList.length;
        for (String name : nameList) {
            cars.add(new Car(name));
        }

        int racingCnt = parseRacingCnt(secondInput);
        validateRacingCnt(racingCnt);

        for (int i = 0; i < racingCnt; i++) {
            moveCar();
            viewRace();
        }

        viewWinner();
    }

    private void moveCar() {
        for (Car car : cars) {
            isMoved(car);
        }
    }

    private void isMoved(Car car) {
        int randZeroNine = Randoms.pickNumberInRange(0, 9);
        if (randZeroNine >= 4) {
            car.moveOnePosition();
        }
    }

    private void viewRace() {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printRacingDistance(car);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void printRacingDistance(Car car) {
        for (int j = 0; j < car.getRacingPosition(); j++) {
            System.out.print("-");
        }
    }

    private void viewWinner() {
        ArrayList<String> winner = new ArrayList<>();

        setWinnerDistance();

        for (Car car : cars) {
            if (isWinner(car)) {
                winner.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winner));
    }

    private boolean isWinner(Car car) {
        return car.getRacingPosition() == winnerDistance;
    }

    private void setWinnerDistance() {
        for (Car car : cars) {
            if (car.getRacingPosition() > winnerDistance) {
                winnerDistance = car.getRacingPosition();
            }
        }
    }

    private void validateName(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자가 넘는 이름 입력");
        }
        if (name.equals(" ")) {
            throw new IllegalArgumentException("공백인 값 입력");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("연속으로 쉼표 2개 이상 입력");
        }
    }

    private int parseRacingCnt(final String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값 입력");
        }
    }

    private void validateRacingCnt(final int racingCnt) {
        if (racingCnt <= 0) {
            throw new IllegalArgumentException("0이거나 음수인 값 입력");
        }
    }
}
