package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int turn;

    public void play(){
        initializeGame();
        race();
        findWinner();
    }

    private void race() {
        while(turn-- > 0){
            for(Car car : cars){
                moveCar(car);
            }
            System.out.println();
        }
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

    private void moveCar(Car car){
        int randomNum = Randoms.pickNumberInRange(0,9);
        car.move(randomNum);
    }

    private void findWinner() {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();

        for(Car car : cars){
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }

        StringBuilder printWinner = new StringBuilder();
        printWinner.append("최종 우승자 : ");
        for(int i=0; i<winners.size(); i++){
            if(i >= 1){
                printWinner.append(", ").append(winners.get(i).getName());
            }
            else{
                printWinner.append(winners.get(i).getName());
            }
        }
        System.out.println(printWinner);
    }
}
