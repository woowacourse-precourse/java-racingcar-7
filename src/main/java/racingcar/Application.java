package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

//car 클래스 추가
class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean shouldMove) {
        if (shouldMove) {
            position++;
        }
    }
}


class CarNameInput {
    public String getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
}

//입력된 자동차 이름 쉼표로 구분하기
 class CarNameParser{
    public List<String> parse(String input){
        return Arrays.asList(input.split(","));
    }
}

//입력된 자동차 이름이 5자가 넘는지 확인하는 클래스
class CarNameValidator{
    public void validate(List<String> carNames){
        for(String name : carNames){
            if(name.trim().length()>5){
                throw new IllegalArgumentException("5자 이하로 입력부탁");
            }
        }
    }
}

class CounterInput{
    public int getInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}

//난수 생성 클래스
class RandomNumberGenerator{
    public int generate(){
        return Randoms.pickNumberInRange(0,9);
    }
}

//각 자동차 마다 생성된 난수 값을 부여하는 클래스

class CarRandomValueAssigner{
    public void assign(Car car ,int randomValue){
        car.move(randomValue>=4);
    }
}
//생성된 난수가 4 이상인지 판별하는 기능
interface MoveStrategy {
    boolean canMove(int randomValue);
}

//생성된 난수가 4 이상일 경우 전진하는 클래스
class CarMover {
    public void move(Car car, MoveStrategy strategy, int randomValue) {
        if (strategy.canMove(randomValue)) {
            car.move(true);
        }
    }
}
class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(int randomValue) {
        return randomValue >= 4;
    }
}
//멈추는 기능
class CarStopper {
    public void stop(Car car) {
        car.move(false);
    }
}

//현재 실행결과가 출력되는 클래스
class RoundResultPrinter {
    public void print(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder result = new StringBuilder(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }
            System.out.println(result.toString());
        }
    }
}

//시도횟수만큼 반복하는 클래스
class GameRepeater {
    public void repeat(List<Car> cars, int attempts, MoveStrategy strategy) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        CarMover carMover = new CarMover();
        CarRandomValueAssigner assigner = new CarRandomValueAssigner();
        RoundResultPrinter printer = new RoundResultPrinter();

        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                int randomValue = randomNumberGenerator.generate();
                assigner.assign(car, randomValue);
                carMover.move(car, strategy, randomValue);
            }
            printer.print(cars);
            System.out.println();
        }
    }
}

//우승자 판별 기능 추가
class WinnerCalculator {
    public List<String> calculate(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}

//우승자 출력 클래스
class WinnerPrinter {
    public void print(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

//오류 출력 클래스
class ErrorPrinter {
    public void print(String message) {
        System.out.println(message);
    }
}

public class Application {
    public static void main(String[] args) {
        try {
            CarNameInput carNameInput = new CarNameInput();
            String carNameInputStr = carNameInput.getInput();

            CarNameParser parser = new CarNameParser();
            List<String> carNames = parser.parse(carNameInputStr);

            CarNameValidator validator = new CarNameValidator();
            validator.validate(carNames);

            List<Car> cars = new ArrayList<>();
            for (String name : carNames) {
                cars.add(new Car(name));
            }

            CounterInput attemptInput = new CounterInput();
            int attempts = attemptInput.getInput();  // 시도 횟수를 먼저 입력받음

            GameRepeater repeater = new GameRepeater();
            MoveStrategy strategy = new RandomMoveStrategy();
            repeater.repeat(cars, attempts, strategy);  // 이제 attempts 변수가 초기화된 후 사용됩니다

            WinnerCalculator winnerCalculator = new WinnerCalculator();
            List<String> winners = winnerCalculator.calculate(cars);

            WinnerPrinter winnerPrinter = new WinnerPrinter();
            winnerPrinter.print(winners);

        } catch (IllegalArgumentException e) {
            ErrorPrinter errorPrinter = new ErrorPrinter();
            errorPrinter.print(e.getMessage());
        }
    }
}
