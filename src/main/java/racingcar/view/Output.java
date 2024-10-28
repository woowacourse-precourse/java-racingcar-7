package racingcar.view;

import java.util.List;

public class Output {

    public void output(List<String> winners){
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
