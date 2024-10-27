package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> nameList;
        int turn = 0;

        //자동차 이름 n개, 턴 수 입력받기
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        nameList = Arrays.asList(input.split(","));
        input = camp.nextstep.edu.missionutils.Console.readLine();
        turn = Integer.parseInt(input);

        for(int i = 0; i < nameList.size(); i++) {
            if(nameList.get(i).length() > 5) { throw new IllegalArgumentException(); }
        }

    }
}
