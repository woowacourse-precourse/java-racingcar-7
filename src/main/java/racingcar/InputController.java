package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputController {
    private List<String> carNames;
    private Integer tryCount;

    InputController() {
    }

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] userInput = Console.readLine().split(",");

        Set<String> carNamesSet = new HashSet<>();
        List<String> carNames = new ArrayList<>();

        for (String input: userInput){
            String car = input.trim();
            if (car.isEmpty()){
                throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
            }
            if (car.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (!carNamesSet.add(car)){
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
            carNames.add(car);
        }
        return carNames;
    }

    public Integer readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Integer getTryCount() {
        return tryCount;
    }
}
