package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = splitName(getName());
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(getNum());
        result(nameList, num);

    }

    public static String getName() {
        return Console.readLine();
    }
    public static String getNum() {
        return Console.readLine();
    }

    public static int randomNum(){
        int a = Randoms.pickNumberInRange(0,9);
        System.out.println("랜덤숫자" + a); // 디버깅용
        return a;
    }

    public static String numBar(int randomNum){
        String bar;
        if(randomNum>3){
            return "-";
        }
        return "";
    }

    public static String[] splitName(String name){
        return name.split(",");
    }

    public static void result(String[] nameList, int num){
        System.out.println("실행 결과");

        String[] barList = new String[nameList.length];
        for(int j = 0; j< barList.length; j ++){
            barList[j] = "";
        }

        int i = 0;
        while(i<num){
            for(int j =0; j< nameList.length; j++){
                barList[j] +=numBar(randomNum());
                System.out.println(nameList[j] +" : " + barList[j]);
            }
            System.out.println();
            i++;
        }

    }

}
