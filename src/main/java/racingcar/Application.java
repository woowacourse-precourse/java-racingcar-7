package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.GameController;
import racingcar.service.MoveDecision;
import racingcar.view.InputUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /**
         * 이름 입력받기
         * 시도할 횟수 입력받기
         * 0-9 무작위 값 구하기
         * 4 이상이면 전진
         * 우승자 발표
         * 잘못된 값 입력 시 IllegalArgumentException 발생시킨 후 종료
         * -> 5자 이하, 숫자아님
         */

        // 사용자 입력 확인
//        InputUser s = new InputUser();
//        System.out.println(s.inputNames());
//        System.out.println(s.inputNumber());

        // 랜덤 값 추출 확인
//        int random = Randoms.pickNumberInRange(0,9);
//        System.out.println(random);

        // 랜덤 값 4 이상 시 true, 아닐 시 false 출력 확인
//        MoveDecision m = new MoveDecision();
//        System.out.println(m.isFour());
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
