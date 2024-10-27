package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class GetInputView {

    public List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameset = Console.readLine();
        String[] checkedname = nameset.split(",");

        validateNameLength(checkedname);

        List<Car> cars = new ArrayList<>();
        for (String carname : checkedname) {
            cars.add(new Car(carname.trim(), 0, ""));
        }
        return cars;
    }

    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void validateNameLength(String[] checkedname) {
        for (String name : checkedname) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }



}
