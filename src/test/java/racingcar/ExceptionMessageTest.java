package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarNames;
import racingcar.model.entity.RacingChance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionMessageTest {

    @Test
    @DisplayName("에러 메시지 테스트 주행 시도 횟수 입력이 0인 경우")
    void chanceInputStringExceptionTest1() {
        String zeroChance = "0";
        try {
            RacingChance chance = RacingChance.getAfterValidateFormat(zeroChance);
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 시도할 횟수는 1 이상이어야 합니다.",
                    e.getMessage());
        }
    }

    @Test
    @DisplayName("에러 메시지 테스트 주행 시도 횟수 입력이 int 범위를 넘는 경우")
    void chanceInputStringExceptionTest2() {
        String outOfBound = "111111111111111111111";
        try {
            RacingChance chance = RacingChance.getAfterValidateFormat(outOfBound);
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 숫자가 아니거나 " +
                    "int 범위(2의 31승 - 1)를 벗어납니다.", e.getMessage());
        }
    }

    @Test
    @DisplayName("에러 메시지 테스트 주행 시도 횟수 입력이 숫자가 아닌 경우")
    void chanceInputStringExceptionTest3() {
        String noDigits = "마음껏달려";
        try {
            RacingChance chance = RacingChance.getAfterValidateFormat(noDigits);
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 숫자가 아니거나 " +
                            "int 범위(2의 31승 - 1)를 벗어납니다.", e.getMessage());
        }
    }

    @Test
    @DisplayName("에러 메시지 테스트 주행 시도 횟수 입력이 없는 경우(엔터만 입력)")
    void chanceInputStringExceptionTest4() {
        String justEnter = "";
        try {
            RacingChance chance = RacingChance.getAfterValidateFormat(justEnter);
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 문자열이 공백입니다. 숫자를 입력하세요.",
                    e.getMessage());
        }
    }

    @Test
    @DisplayName("자동차 이름 형식이 잘못된 경우")
    void carNamesInputStringExceptionTest4() {
        String breakLengthLimit = "longnameislong,james";
        try {
            CarNames names = CarNames.getAfterValidateFormat(breakLengthLimit);
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 올바른 자동차 이름 형식이 아닙니다. " +
                            "이름에 허용되는 문자는 알파벳, 한글, 아라비아 숫자입니다.",
                    e.getMessage());
        }
    }

}
