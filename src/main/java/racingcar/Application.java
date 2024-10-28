package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void move() {
        if (canMove()) {
            position++; // 무작위 숫자가 4 이상일 경우 전진
        }
    }
    public boolean canMove() {
        return new Random().nextInt(10) >= 4; // 0부터 9까지의 무작위 숫자 생성
    }
    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
public class Application {
    private final List<Car> cars;
    private final int rounds;

    public Application(List<String> carNames, int rounds) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            cars.add(new Car(name));
        }
        this.rounds = rounds;


    }
    public void start() {
        System.out.println("실행 결과:");
        for (int i = 0; i < rounds; i++) {
            playRound();
            printStatus();
        }
        printWinners();
    }
    private void playRound() {
        for (Car car : cars) {
            car.move(); // 각 자동차 이동
        }
    }
    private void printStatus() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
    private void printWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesInput = sc.nextLine().split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : carNamesInput) {
            carNames.add(name.trim());
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds = sc.nextInt();

        Application cargame = new Application(carNames, rounds);
        cargame.start();
    }
}
