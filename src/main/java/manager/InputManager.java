package manager;

import camp.nextstep.edu.missionutils.Console;
import car.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validation.InputValidator;

public class InputManager {
    private final InputValidator inputValidator;
    public InputManager(InputValidator inputValidator){
        this.inputValidator = inputValidator;
    }

    public List<Car> inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Integer inputMoveCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
