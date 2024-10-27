package racingcar.view;

import racingcar.domain.Winners;

public class WinnersView {

    public void show(Winners winners) {
        String result = winners.getWinnersList();
        System.out.print("최종 우승자 : " + result);
    }
}
