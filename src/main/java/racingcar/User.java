package racingcar;

import static racingcar.Constant.INPUT_CARS;
import static racingcar.Constant.INPUT_MOVES;
import static racingcar.Constant.INTEGER_MESSAGE;
import static racingcar.Validation.inputLastIndexValidate;
import static racingcar.Validation.inputValidate;
import static racingcar.Validation.moveValidate;
import static racingcar.Validation.nameDuplicateValidate;
import static racingcar.Validation.nameLengthValidate;
import static racingcar.Validation.tooManyCarsValidate;
import static racingcar.Validation.tooManyMovesValidate;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String DELIMITER = ",";

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
        System.out.println(INPUT_MOVES);

        try {
            moves = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_MESSAGE);
        }

        moveValidate(moves);
        tooManyMovesValidate(moves);

        Console.close();

        return moves;
    }

    private List<String> inputCarName() {
        List<String> cars = new ArrayList<>();

        System.out.println(INPUT_CARS);
        String input = Validation.inputValidate(Console.readLine());

        inputLastIndexValidate(input);

        String[] carName = input.split(DELIMITER);

        for (String car : carName) {
            nameLengthValidate(car);
            nameDuplicateValidate(car, cars);
            cars.add(inputValidate(car));
        }

        tooManyCarsValidate(cars);

        return cars;
    }
}