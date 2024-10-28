package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static String[] inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine().trim();
        return line.split(",");
    }

    public static int inputNum(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine().trim();
        return Integer.parseInt(input);
    }

    public static boolean Movement(){ //true:전진 false:정지
       int randomNum = Randoms.pickNumberInRange(0, 9);
       return randomNum >= 4;
    }

    public static void display(String[] arr){ // 실행 결과 출력

        System.out.println("실행 결과");

        String[] move = new String[arr.length];

        for(int i = 0; i < arr.length; i++){
            if(Movement())
                move[i] += "-";
            else
                move[i] += "";
            System.out.println(arr[i] + " : " + move[i]);
        }

        List<String> longestStrings = new ArrayList<>();
        int maxLength = 0;

        for(String str: arr){
            if(str.length() > maxLength){
                maxLength = str.length();
                longestStrings.clear();
                longestStrings.add(str);
            }
            else if(str.length() == maxLength){
                longestStrings.add(str);
            }
        }
        System.out.println("최종 우승자 : " + longestStrings);
    }
}
