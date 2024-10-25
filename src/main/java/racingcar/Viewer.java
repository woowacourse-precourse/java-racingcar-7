package racingcar;

import java.util.List;

public class Viewer {

    public void promptCarNamesInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public void displayWinners(List<String> winners){
        System.out.println("최종 우승자 : " + winners);
    }
}
