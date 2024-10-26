package racingcar.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    public static List<String> inputCarName() {

        System.out.println("참여할 자동차 이름을 알려주세요");
        String input = readLine();

        return splitCarName(input);
    }

    public static List<String> splitCarName (String input) {

        // 이름은 콤마(,) 로만 구분 - 예외 사항 없다고 가정
        String[] carNameArray = input.split(",");

        List<String> carNameList = new ArrayList<>();

//        for(String name : carNameArray) {
//            carNameList.add(name);
//        }

        carNameList.addAll(Arrays.asList(carNameArray));

        return carNameList;

    }

}
