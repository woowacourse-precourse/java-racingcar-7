package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> names = userInput();
//        System.out.println(names);
    }

    // 사용자로부터 입력을 받아 경주할 자동차 이름 배열 반환
    public static List<String> userInput(){
        String names = Console.readLine();
        return concatNames(names);
    }

    public static List<String> concatNames(String names){
        List<String> nameList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(names,",");
        while (st.hasMoreTokens()){
            nameList.add(st.nextToken());
        }
        return nameList;
    }
}
