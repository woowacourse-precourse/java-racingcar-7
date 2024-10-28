package racingcar.view.outputView;

import racingcar.model.Car;
import racingcar.model.WinnerSelector;
import racingcar.view.outputView.OutputView;

import java.util.List;

public class WinnersOutputView implements OutputView {
    private final List<Car> winners;

    public WinnersOutputView(WinnerSelector winnerSelector){
        this.winners = winnerSelector.getWinners();
    }

    public void print(){
        System.out.print("최종 우승자 : ");

        for(int i = 0; i < winners.size(); i++){
            System.out.print(makePrintFormat(winners.get(i).getName(), i));
        }
    }

    private String makePrintFormat(String carName, Integer i){
        String format = "";
        StringBuilder sb = new StringBuilder();
        sb.append(carName + ", ");

        if(i == winners.size() - 1){
            format = sb.deleteCharAt(sb.lastIndexOf(",")).toString().trim();
        }
        else{
            format = sb.toString();
        }

        return format;
    }
}
