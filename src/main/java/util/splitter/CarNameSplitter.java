package util.splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameSplitter {
    public List<String> splitCarNames(String input) {
        return new ArrayList<String>(Arrays.asList(input.split(",")));
    }
}