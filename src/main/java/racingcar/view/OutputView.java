package racingcar.view;

import java.util.List;

public class OutputView {
    public void printPlayMessage(){
        System.out.println();
        System.out.println("실행결과");
    }

    public void printPlayResults(List<String> results){
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }
}
