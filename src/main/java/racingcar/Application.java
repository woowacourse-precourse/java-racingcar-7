package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsString = Console.readLine();
        String[] carNames = carsString.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine();
        System.out.println();
        int tryNum = Integer.parseInt(tryNumString);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        RacingGame game = new RacingGame(new Cars(cars), new RandomMoveCondition());
        List<Integer> positions = new ArrayList<>();
        int numOfCars = 0;
        System.out.println("실행 결과");
        for (int i = 0; i < tryNum; i++) {
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
