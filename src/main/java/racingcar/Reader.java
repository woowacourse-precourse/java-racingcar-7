package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Reader implements ReaderInterface{

    @Override
    public List<String> getNameInput() {
        String nameInput = readLine();
        try {
            List<String> names = Arrays.stream(nameInput.split(",")).toList();

            if (validNameInput(names)) {
                return names;
            }
            else{
                throw new IllegalArgumentException("invalid name");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("can't parse names");
        }

    }

    private boolean validNameInput(List<String> names) {
        if (names.isEmpty() || new HashSet<>(names).size() != names.size()) {
            return false;
        }
        for (String name : names) {
            if (name.isBlank() || name.length() > MAX_NAME_LENGTH){
                return false;
            }
        }
        return true;
    }

    @Override
    public int getTryInput() {
        try {
            String tryInput = readLine();
            if (validTryInput(tryInput)) {
                return Integer.parseInt(tryInput);
            } else {
                throw new IllegalArgumentException("must try more than once");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("not an positive integer input");
        }
    }

    private boolean validTryInput(String raps) {
        return !raps.isBlank() && Integer.parseInt(raps) >= MIN_RAPS;
    }
}
