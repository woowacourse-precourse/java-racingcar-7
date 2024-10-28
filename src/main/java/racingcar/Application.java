package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }
    public String getNma() {
        return name;
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
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesInput = sc.nextLine().split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : carNamesInput) {
            carNames.add(name.trim());
        }
    }
}
