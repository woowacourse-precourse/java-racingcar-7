package racingcar.view;

import racingcar.domain.InputDTO;

import static camp.nextstep.edu.missionutils.Console.readLine;

//자동차이름 5글자 이상인지 판단
//공백만 들어온 경우에 대한 예외처리
//,를 기준으로 앞 뒤에 공백은 지우고 중간 문자열 중간의 공백은 유지
public class RacingCarView {

    public InputDTO getInputCarName() {
        String input = readLine();

        return new InputDTO(input);
    }

    public int getRoundTime(){
        String input = readLine();

        return Integer.parseInt(input);
    }

    public void showCarInputInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRoundTimeInfo(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

}


