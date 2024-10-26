package racingcar.io.page;

public interface Page<T> {

    void isNewLineAtEOF(boolean isNewLineAtEOF);

    boolean isNewLineAtEOF();

    void setContent(T content);

    T getContent();

    void render();

    void render(T content);

}
