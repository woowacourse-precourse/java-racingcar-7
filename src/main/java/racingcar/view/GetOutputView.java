package racingcar.view;

import java.util.List;

public class GetOutputView {

    public void getOutput(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

}
