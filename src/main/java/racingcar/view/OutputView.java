package racingcar.view;

import java.util.List;

public class OutputView {
    public OutputView() {
    }

    public void output(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void roundResultView(List<String> carNames, List<String> carDistance) {
        for(int i=0;i< carNames.size();i++){
            String result = carNames.get(i) + " : " + carDistance.get(i);
            System.out.println(result);
        }
        System.out.println();
    }
    public void startGame(){
        System.out.println();
        System.out.println("실행 결과");
    }
}
