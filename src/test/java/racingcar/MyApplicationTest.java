package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyApplicationTest extends NsTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    void 중복이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, pobi, woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실행횟수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "jun"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정상실행_테스트() {
        ArrayList<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");

        int moveCount = 4;

        System.setIn(new ByteArrayInputStream((String.join(",", carNames) + "\n" + moveCount).getBytes()));

        runMain();
        String output = output();

        Pattern pattern = Pattern.compile("최종 우승자 : (.+)");
        Matcher matcher = pattern.matcher(output);
        String winners = "";

        if (matcher.find()) {
            winners = matcher.group(1);
        } else {
            assertThat(false).isTrue();
        }

        for (String winner: winners.split(",")) {
            assertThat(carNames).contains(winner.trim());
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
