package racingcar.io.page;

import racingcar.io.read.Reader;
import racingcar.io.read.StringReader;

public class SimpleTextReaderPage implements ReaderPage<String, String> {

    private Reader<String> reader;

    private Page<String> page;

    private String output;

    public SimpleTextReaderPage() {
        this.reader = new StringReader();
        this.page = new SimpleTextPage();
        this.output = null;
    }

    public SimpleTextReaderPage(String content) {
        this.reader = new StringReader();
        this.page = new SimpleTextPage(content);
        this.output = null;
    }

    public SimpleTextReaderPage(Reader<String> reader) {
        this.reader = reader;
        this.page = new SimpleTextPage();
        this.output = null;
    }

    public SimpleTextReaderPage(Page<String> page) {
        this.reader = new StringReader();
        this.page = page;
        this.output = null;
    }

    public SimpleTextReaderPage(Reader<String> reader, Page<String> page) {
        this.reader = reader;
        this.page = page;
        this.output = null;
    }

    @Override
    public void setReader(Reader<String> reader) {
        this.reader = reader;
    }

    @Override
    public Reader<String> getReader() {
        return this.reader;
    }

    @Override
    public String getOutput() {
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
    public String read() {
        return this.reader.read();
    }
}
