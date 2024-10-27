package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<String> winners = new ArrayList<>();
    int maxTurn = 0;

    public void runGame(){

        setGame();
        playGame();
        afterGame();
    }

    /// 레이싱게임 입력부분
    private void setGame(){
        //Todo: 한 가지 기능을 하는 함수로 나누기

        String[] carNameArray = inputCarName(); // 자동차 이름 입력받아서 배열에 저장
        // Todo: 자동차 입력 예외처리

        // 자동차 정보 저장
        for(String carName : carNameArray){

            // Todo: 중복확인 예외처리
            cars.add(new Car(carName));
        }
        //Todo: 사용자로부터 maxTurn 입력받기
    }

    /// 자동차 이름을 입력받아 문자열 배열을 리턴
    private String[] inputCarName(){

        String carNameString = Console.readLine(); // 사용자로부터 자동차 이름 입력받기
        carNameString = carNameString.trim();

        // 입력한 자동차 이름으로 생성한 배열 리턴
        return carNameString.split(",");
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
