package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printWinner(List<String> winner){
        String result = "최종 우승자 : " + String.join(", ", winner);
        System.out.println(result);
    }

    public static void nowResult(String name, String position){
        System.out.println(name+" : "+position);
    }

    public static void racingResult(){
        newLine();
        System.out.println("실행 결과");
    }

    public static void newLine() {
        System.out.println(); // 줄바꿈
    }
}
