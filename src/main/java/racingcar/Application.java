package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static String inputText() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = Console.readLine();
        return text;
    }

    public static List<Car> createCarList(String text) {
        List<Car> carList = new ArrayList<>();

        for (String carName : text.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(carName));
        }

        return carList;
    }

    public static int inputTestCaseNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int testCase = Integer.parseInt(input);
        return testCase;
    }

    public static void racingCar(int tc, List<Car> carList) {
        System.out.println("실행 결과");

        while (tc >= 0) {
            for (Car car : carList) {
                car.move();
                car.print();
            }
            tc--;
        }
    }

    public static int findMax(List<Car> cars) {
        // list를 받아서 가장 많이 전진한 car를 찾는 메서드
        int mx = 0;
        for (Car car : cars) {
            if (mx < car.getMoveCount()) {
                mx = car.getMoveCount();
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String text = inputText();

        List<Car> carList = new ArrayList<>();
        carList = createCarList(text);

        int tc = inputTestCaseNum();

        racingCar(tc, carList);

        System.out.println();
        int mx = findMax(carList);

        
    }
}
