package racingcar.separator;

import java.util.ArrayList;
import java.util.List;

public class Extractor {
    private static final char COMMA = ',';

    public static List<String> extract(String input) {
        List<String> names = new ArrayList<>();
        int startidx = 0;

        for(int i = 0; i<input.length(); i++) {
            if(input.charAt(i) == COMMA){
                String name = input.substring(startidx, i);
                names.add(name.trim());
                startidx = i + 1;
            }
        }

        names.add(input.substring(startidx));

        return names;
    }
}