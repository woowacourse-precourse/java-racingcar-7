package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {
    int moveNumber;
    ArrayList<Car> cars;

    List<String> readCarName(){
        System.out.println("게임을 진행할 자동차들의 이름을 쉼표(,)로 구분하여 입력 해주세요.");
        List<String> carNames = new ArrayList<>();
        try{
            String readString= Console.readLine();
            String regex = "^([A-Za-z0-9][A-Za-z0-9 ]{0,4})(,[A-Za-z0-9][A-Za-z0-9 ]{0,4})*$";
            if(Pattern.matches(regex, readString))
                throw new IllegalArgumentException();
            carNames = List.of(readString.split(","));

        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    public void createCars(List<String> carNames){
        if(carNames.isEmpty())
            throw new IllegalArgumentException();
        cars = new ArrayList<Car>();
        for(String carName : carNames)
            cars.add(new Car(carName));
    }

    public Game(){
        List<String> carNames = readCarName();
        createCars(carNames);
    }


}
