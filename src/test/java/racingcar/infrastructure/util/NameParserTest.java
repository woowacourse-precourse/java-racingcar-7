package racingcar.infrastructure.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameParserTest {

    private NameParser nameParser;

    @BeforeEach
    public void before(){
        nameParser = new NameParser();
    }

    //=======================Success Test=======================//
    @Test
    void 콤마로_구분되는지_확인하기() {
        String names = "jong,name,test";

        List<String> nameList = nameParser.parsingName(names);

        assertEquals(nameList, List.of("jong", "name", "test"));
    }

    //=======================Exception Test=======================//
    @Test
    void 공백_확인하기() {
        String names = "";
        assertThrows(IllegalArgumentException.class, () -> nameParser.parsingName(names));
    }
}