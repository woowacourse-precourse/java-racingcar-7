package racingcar.view;

import java.util.Map;

public class OutputView {

    public void racingView(Map<String, Integer> cars){
        for(Map.Entry<String, Integer> entry : cars.entrySet()){
            System.out.print(entry.getKey() + " : ");
            for(int i=0; i<entry.getValue(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
