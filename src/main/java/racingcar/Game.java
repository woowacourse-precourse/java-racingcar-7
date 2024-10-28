package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> cars = new ArrayList<>();

    public void start() {
        View view = new View();

        List<String> carNames;
        String input;
        int count;


        input = view.inputCars();
        carNames = view.inputCarNames(input); //이름 리스트 생성
        count = view.inputCount();
        cars = addCars(carNames);
        playResult(count, cars);
        printWinners(winners(cars));
    }

    public List<Car> addCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void playResult(int count, List<Car> cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {

            for (Car car : cars) {
                printGame(car);
            }
            System.out.println();

        }
    }

    public List<String> winners(List<Car> cars) {
        int max = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > max)
                max = car.getPosition();
        }
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private void printGame(Car car) { //start
        car.move();
        car.getPosition();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
