package racingcar.outputManager;

import java.util.List;
import racingcar.car.Car;

public class ConsoleOutputManager implements OutputManager {
    @Override
    public void printExecutionResult(List<Car> progressResult) {
        System.out.println();

        for (Car car : progressResult) {
            int distance = car.getDistance();
            String name = car.getName();
            printResult(distance, name);
        }
    }

    private void printResult(int distance, String name) {
        System.out.print(name + " : ");

        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    @Override
    public void printWinner(List<Car> winner) {
        System.out.println();
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winner.size(); i++) {
            printName(winner, i);
        }
    }

    private void printName(List<Car> winner, int index) {
        if (index != winner.size() - 1) {
            System.out.print(winner.get(index).getName() + ", ");
        } else {
            System.out.print(winner.get(index).getName());
        }
    }
}
