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

    public void start() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        while (tryCount-- > 0) {
            moveCars();
            printCars();
        }
        printResult();
    }

    private void printCars() {
        StringBuilder sb = new StringBuilder();
        List<String> carNames = carCollection.getCarNames();
        for (int i = 0; i < carCollection.carCount(); i++) {
            sb.append(carNames.get(i) + " : ");
            List<Integer> carMoveCountList = carCollection.getCarMoveCount();
            sb.append("-".repeat(carMoveCountList.get(i)));
            sb.append("\n");
        }
        System.out.println(sb);
    }


    private void moveCars() {
        for (int i = 0; i < carCollection.carCount(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            carCollection.moveCar(i, randomNum);
        }
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        String result = String.join(", ", carCollection.getWinnerList());
        sb.append(result);
        System.out.println(sb);
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
        for (Car car : carList) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public void moveCar(int index, int randomNum) {
        if (randomNum >= 4) {
            Car car = carList.get(index);
            car.move();
        }
    }

    public int carCount() {
        return carList.size();
    }

    public List<Integer> getCarMoveCount() {
        List<Integer> carMoveCountList = new ArrayList<>();
        for (Car car : carList) {
            carMoveCountList.add(car.getMoveCount());
        }
        return carMoveCountList;
    }

    public List<String> getWinnerList() {
        int maxMoveCount = carList.stream()
            .mapToInt(car -> car.getMoveCount()).max().getAsInt();

        List<String> winners = carList.stream()
            .filter(car -> car.getMoveCount() == maxMoveCount)
            .map(car -> car.getName()).toList();

        return winners;
    }
}

