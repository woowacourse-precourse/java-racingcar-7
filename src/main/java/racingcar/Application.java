package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        RacingGameInput input = new RacingGameInput();
        List<String> carNames = input.readCarNames();
        int tryCount = input.readTryCount();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        RacingGame game = new RacingGame(Cars.withNames(carNames), new RandomMoveCondition());
        List<Integer> positions = new ArrayList<>();
        int numOfCars = 0;
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            positions = game.race();
            numOfCars = positions.size();
            for (int j = 0; j < numOfCars; j++) {
                StringBuilder positionRenderer = new StringBuilder();
                Integer position = positions.get(j);
                positionRenderer.append("-".repeat(Math.max(0, position)));
                System.out.println(cars.get(j).getName() + " : " + positionRenderer);
            }
            System.out.println();
        }

        StringBuilder winner = new StringBuilder();
        int winPosition = 0;
        for (int i = 0; i < numOfCars; i++) {
            Integer position = positions.get(i);
            if (winPosition < position) {
                winPosition = position;
            }
        }
        for (int i = 0; i < numOfCars; i++) {
            Integer position = positions.get(i);
            if (winPosition == position) {
                winner.append(cars.get(i).getName());
                winner.append(", ");
            }
        }
        winner.delete(winner.length() - 2, winner.length() - 1);
        System.out.println("최종 우승자 : " + winner);
    }
}
