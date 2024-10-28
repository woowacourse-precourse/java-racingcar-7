package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {
    BufferedReader bufferedReader;
    int moveNumber;
    ArrayList<Car> Cars;

    List<String> readCarName(){
        System.out.println("게임을 진행할 자동차들의 이름을 쉼표(,)로 구분하여 입력 해주세요.");
        List<String> carNames = new ArrayList<>();
        try{
            String readString= bufferedReader.readLine();
            String regex = "^([A-Za-z0-9][A-Za-z0-9 ]{0,4})(,[A-Za-z0-9][A-Za-z0-9 ]{0,4})*$";
            if(Pattern.matches(regex, readString))
                throw new IllegalArgumentException();
            carNames = List.of(readString.split(","));

        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }


    public Game(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        readCarName();
    }


}
