package racingcar;

import java.util.ArrayList;

public class RacingGame {

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<String> winners = new ArrayList<>();
    int maxTurn = 0;

    public void runGame(){
        setGame();
        playGame();
        afterGame();
    }


    private void setGame(){
        //Todo: 사용자로부터 maxTurn, 자동차 이름 입력받기
        //Todo: 자동차이름을 ','로 구분지어 자동차 리스트에 추가하기
        //Todo: 입력 예외처리 추가하기(README 참조)
        //Todo: 한 가지 기능을 하는 함수로 나누기
    }

    private void playGame(){
        //Todo: maxTurn번 반복하기
        //Todo: 무작위 수를 이용하여 자동차 움직이기
        //Todo: 한 가지 기능을 하는 함수로 나누기
    }

    private void afterGame(){
        //Todo: 각 자동차별 최종 거리를 이용하여, 1등 거리 구하기
        //Todo: 1등 거리에 해당하는 자동차 이름을 winners 배열에 저장
        //Todo: winners 배열을 통해 우승자 출력하기
        //Todo: 한 가지 기능을 하는 함수로 나누기
    }

}
