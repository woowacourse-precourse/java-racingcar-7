package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {


    public List<String> grantCarName(){
        List<String> cars = new ArrayList<>();

        String[] carName = Console.readLine().split(",");

        Collections.addAll(cars, carName);

        Console.close();

        return cars;
    }

    public int moves(){

        int moves = Integer.parseInt(Console.readLine());

        Console.close();

        return moves;
    }

}
