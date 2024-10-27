package racingcar.prompt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PromptModel {
    private final HashMap<String, String> readData = new HashMap<>();
    private final List<String> writeData = new ArrayList<>();

    public void add(String value) {
        writeData.add(value);
    }

    public void add(String key, String value) {
        readData.put(key, value);
    }

    public String get(String key) {
        return readData.get(key);
    }

    public Iterator<String> get() {
        return writeData.iterator();
    }
}
