package racingcar.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final int roundNumber;

    public static Racing makeRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundNumber = Integer.parseInt(Console.readLine());

        List<Car> cars = CarFactory.createCars(carNames);
        return new Racing(cars, roundNumber);
    }

    protected Racing(final List<Car> cars, final int roundNumber) {
        this.cars = cars;
        this.roundNumber = roundNumber;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            playRound();
            displayRoundResult();
        }

        displayWinner();
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void displayRoundResult() {
        for (Car car : cars) {
            car.display();
        }
        System.out.println();
    }

    private void displayWinner() {
        List<Car> winners = getWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners.stream()
                .map(Car::getName)
                .toList()));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
