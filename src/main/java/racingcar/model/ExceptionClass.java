package racingcar.model;

public class ExceptionClass extends Exception {
    private final static ExceptionClass instance = new ExceptionClass();
    private ExceptionClass() {}
    public static ExceptionClass getInstance() {
        return instance;
    }

    public void checkStringLength(String string){
        if(string.length() > 5){
            throw new IllegalArgumentException("String length can't be greater than 5");
        }
    }
}
