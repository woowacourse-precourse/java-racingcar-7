package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.start();
    }
}

class Racing {

    InputString inputString;
    CarCollection carCollection;

    Racing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        inputString = new InputString(str);
        carCollection = inputString.getCarCollection();
    }

    Racing(String str){
        inputString = new InputString(str);
        carCollection = inputString.getCarCollection();
    }

    public void start(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        // 시도한 횟수만큼 진행

    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}


class InputString {

    private String inputString;

    InputString(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException();
        }
        inputString = string;
    }

    public String getInputString() {
        return inputString;
    }

    public CarCollection getCarCollection() {
        String names[] = inputString.split(",");
        checkingValid(names);
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return new CarCollection(carList);
    }

    private static void checkingValid(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}

class CarCollection {

    private List<Car> carList;

    public CarCollection(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for(Car car: carList)
            carNames.add(car.getName());
        return carNames;
    }
}

class Car {

    private String name;
    private int moveCount = 0;

    Car(String name) {
        this.name = name;
    }

    public void move() {
        this.moveCount++;
    }

    public String getName() {
        return name;
    }
}