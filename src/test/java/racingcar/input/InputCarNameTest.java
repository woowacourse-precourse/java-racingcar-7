package racingcar.input;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.config.exception.input.name.DelimiterNameException;
import racingcar.config.exception.input.name.DuplicateNameException;
import racingcar.config.exception.input.name.EmptyNameException;
import racingcar.config.exception.input.name.LengthNameException;
import racingcar.config.exception.input.name.MultipleNameException;
import racingcar.helper.validation.InputNameValid;

public class InputCarNameTest {

    @Test
    void 사용자는_이름에_공백을_입력할_수_없다() {
        String name = "";

        assertThrows(EmptyNameException.class, () -> InputNameValid.validEmptyName(name));
    }

    @Test
    void 사용자는_입력_시_구분자를_사용해야_한다() {
        String name ="pobi mingi";

        assertThrows(DelimiterNameException.class, () -> InputNameValid.validDelimiterName(name));
    }

    @Test
    void 사용자는_여러_개의_이름을_입력해야_한다() {
        String name = "pobi";
        List<String> nameList = new ArrayList<>();
        nameList.add(name);

        assertThrows(MultipleNameException.class, () -> InputNameValid.validMultipleName(nameList));
    }

    @Test
    void 사용자는_5자_이하의_이름을_입력해야_한다() {
        String name = "pobiishandsome";
        List<String> nameList = new ArrayList<>();
        nameList.add(name);

        assertThrows(LengthNameException.class, () -> InputNameValid.validLengthName(nameList));
    }

    @Test
    void 사용자는_중복된_이름을_입력할_수_없다() {
        String name = "pobi";
        List<String> nameList = new ArrayList<>();
        nameList.add(name);
        nameList.add(name);

        assertThrows(DuplicateNameException.class, () -> InputNameValid.validDuplicateName(nameList));
    }
}
