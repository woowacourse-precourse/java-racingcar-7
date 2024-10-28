package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int turn;

    public void play(){
        initializeGame();
    }

    private void initializeGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        cars = createCars(input);

        System.out.println("시도할 횟수를 입력해주세요.");
        turn = ValidateTurn(Console.readLine());
    }

    private int ValidateTurn(String input) {
        try{
            int retTurn = Integer.parseInt(input);
            if(retTurn < 0){
                throw new IllegalArgumentException("시도할 횟수는 양의 정수로 적어주세요.");
            }
            return retTurn;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도할 횟수는 양의 정수로 적어주세요.");
        }
    }

    private List<Car> createCars(String input) {
        String[] names = input.split(",");
        validateDuplicateName(names);
        List<Car> retCars = new ArrayList<>();
        for (String name : names) {
            retCars.add(new Car(name));
        }

        return retCars;
    }

    private void validateDuplicateName(String[] names) {
        HashSet<String> duplicateNames = new HashSet<>(Arrays.asList(names));

        if(duplicateNames.size() != names.length){
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

    }
}
