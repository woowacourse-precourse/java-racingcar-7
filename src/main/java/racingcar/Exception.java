package racingcar;

public class Exception {
    public void except1(String[] strings) {
        for (String str : strings) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("String length exceeds 5 characters: " + str);
            }
        }
    }

    public void except2(int input) {
        if (input<1){
            throw new IllegalArgumentException("Count cannot be less than 1");
        }
    }
}
