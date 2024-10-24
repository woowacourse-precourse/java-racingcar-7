package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

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
    public void assign(Car car int randomValue){
        car.move(randomValue>=4);
    }
}


public class Application {
    public static void main(String[] args) {
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
        int attempts = attemptInput.getInput();


    }
}
