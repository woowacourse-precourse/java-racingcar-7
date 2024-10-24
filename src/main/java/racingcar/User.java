package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {


    public List<String> grantCarName(){
        List<String> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] carName = Console.readLine().split(",");

        Collections.addAll(cars, carName);


        return cars;
    }

    public int moves(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int moves = Integer.parseInt(Console.readLine());

        Console.close();

        return moves;
    }

}
