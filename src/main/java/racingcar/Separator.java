package racingcar;

public class Separator {
    public String[] separate(String inputNames) {
        String tokenizer = ",";
        String[] names = inputNames.split(tokenizer);

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }

        return names;
    }
}
