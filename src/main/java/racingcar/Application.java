package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = splitName(input());
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(input());

        result(nameList, num);

    }

    public static String input() {
        return Console.readLine();
    }

    public static int randomNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static String[] splitName(String name){
        return name.split(",");
    }

    public static void result(String[] nameList, int num){
        System.out.println("실행 결과");

        int i = 0;
        while(i<num){
            for(String name : nameList){
                System.out.println(name + " : ");
            }
            i++;
        }

    }

}
