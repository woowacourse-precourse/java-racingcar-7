package racingcar.io.page;

import racingcar.io.read.IntegerReader;
import racingcar.io.read.Reader;

public class IntegerReaderPage implements ReaderPage<String, Integer> {

    private Reader<Integer> reader;

    private Page<String> page;

    private Integer output;

    public IntegerReaderPage() {
        this.reader = new IntegerReader();
        this.page = new SimpleTextPage();
        this.output = -1;
    }

    @Override
    public void setReader(Reader<Integer> reader) {
        this.reader = reader;
    }

    @Override
    public Reader<Integer> getReader() {
        return this.reader;
    }

    @Override
    public Integer getOutput() {
        return this.output;
    }

    @Override
    public void isNewLineAtEOF(boolean isNewLineAtEOF) {
        this.page.isNewLineAtEOF(isNewLineAtEOF);
    }

    @Override
    public boolean isNewLineAtEOF() {
        return this.page.isNewLineAtEOF();
    }

    @Override
    public void setContent(String content) {
        this.page.setContent(content);
    }

    @Override
    public String getContent() {
        return this.page.getContent();
    }

    @Override
    public void render() {
        this.render(this.page.getContent());
    }

    @Override
    public void render(String content) {
        this.page.render(content);
        this.output = this.read();
    }

    @Override
    public Integer read() {
        return this.reader.read();
    }
}
