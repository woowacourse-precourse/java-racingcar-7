package racingcar.converter;

import java.util.List;

public class ListToStringConverter {

    public String joinListToString(List<String> list) {
        if (list.size() == 1) {
            return list.getFirst();
        } else {
            return String.join(", ", list);
        }
    }

    public String changeNumberToProgressString(long progressNumber) {
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < progressNumber; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
