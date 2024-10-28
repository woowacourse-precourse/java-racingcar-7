package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.GameManage;
import racingcar.UserInterface;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserInterface {
    public enum ConsoleMessage {
        Car_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RESULT("실행 결과"),
        WINNER("최종 우승자 : ");

        private final String message;

        ConsoleMessage(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}