package racingcar;

import static racingcar.Validation.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {


    public List<Car> grantCarName() {
        List<String> carNames = inputCarName();
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    public int grantMoves() {
        int moves;
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            moves = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요. ");
        }

        moveValidate(moves);
        tooManyMovesValidate(moves);

        Console.close();

        return moves;
    }

    private List<String> inputCarName() {
        List<String> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Validation.inputValidate(Console.readLine());

        inputLastIndexValidate(input);

        String[] carName = input.split(",");

        for (String car : carName) {
            nameLengthValidate(car);
            nameDuplicateValidate(car, cars);
            cars.add(inputValidate(car));
        }

        tooManyCarsValidate(cars);

        return cars;
    }
}