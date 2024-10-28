package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 자동차 이름을 입력받음
        List<RacingCar> names = userInput();
        System.out.println(names.get(1).getName());
        // 사용자로부터 횟수를 입력받음
        int times = Integer.parseInt(Console.readLine());
    }

    // 사용자로부터 입력을 받아 경주할 자동차 이름 배열 반환
    public static List<RacingCar> userInput(){
        String names = Console.readLine();
        return concatNames(names);
    }

    public static List<RacingCar> concatNames(String names){
        List<RacingCar> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(names,",");
        while (st.hasMoreTokens()){
            nameList.add(new RacingCar(st.nextToken()));
        }
        return nameList;
    }
}
