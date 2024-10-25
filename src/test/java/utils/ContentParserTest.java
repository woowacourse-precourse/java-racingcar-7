package utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import inspector.InspectName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class ContentParserTest extends NsTest {
    @DisplayName("일반적인_입력_테스트_공백이_없는_경우")
    @Test
    void normal_test_without_whitespace(){
        String[] parsedGroup = ContentParser.parsingContentToGroup("pobi,wony,jun");
        assertThat(parsedGroup).satisfies(
                group -> {
                    assertThat(group[0]).isEqualTo("pobi");
                    assertThat(group[1]).isEqualTo("wony");
                    assertThat(group[2]).isEqualTo("jun");
                });
    }

    @DisplayName("일반적인_입력_테스트_공백이_있는_경우")
    @Test
    void normal_test_with_whitespace(){
        String[] parsedGroup = ContentParser.parsingContentToGroup("pobi, wony, jun");
        assertThat(parsedGroup).satisfies(
                group -> {
                    assertThat(group[0]).isEqualTo("pobi");
                    assertThat(group[1]).isEqualTo("wony");
                    assertThat(group[2]).isEqualTo("jun");
                });
    }

    @DisplayName("전각_문자가_공백으로_들어온_경우_테스트")
    @Test
    void fullwidth_whitespce_removal_test(){
        //전각 문자 : ㄱ + 한자 + 1
        String[] parsedGroup = ContentParser.parsingContentToGroup("　pobi　,　wony　,　jun　");
        assertThat(parsedGroup).satisfies(
                group -> {
                    assertThat(group[0]).isEqualTo("pobi");
                    assertThat(group[1]).isEqualTo("wony");
                    assertThat(group[2]).isEqualTo("jun");
                });
    }

    @DisplayName("전각_문자와_반각이_섞여_공백으로_들어온_경우_테스트")
    @Test
    void fullwidth_and_halfwidth_whitespce_removal_test(){
        //전각 문자 : ㄱ + 한자 + 1
        String[] parsedGroup = ContentParser.parsingContentToGroup("pobi　,　wony　,  jun");
        assertThat(parsedGroup).satisfies(
                group -> {
                    assertThat(group[0]).isEqualTo("pobi");
                    assertThat(group[1]).isEqualTo("wony");
                    assertThat(group[2]).isEqualTo("jun");
                });
    }


    @DisplayName("한글이_입력으로_들어온_경우_테스트")
    @Test
    void korean_input_test(){
        String[] parsedGroup = ContentParser.parsingContentToGroup("　포비　,　워니　,　준　");
        assertThat(parsedGroup).satisfies(
                group -> {
                    assertThat(group[0]).isEqualTo("포비");
                    assertThat(group[1]).isEqualTo("워니");
                    assertThat(group[2]).isEqualTo("준");
                });
    }

    @DisplayName("이모지가_입력으로_들어온_경우_테스트")
    @Test
    void emoji_input_test(){
        String[] parsedGroup = ContentParser.parsingContentToGroup("　😂　,　🫡　,　😥　");
        assertThat(parsedGroup).satisfies(
                group -> {
                    assertThat(group[0]).isEqualTo("😂");
                    assertThat(group[1]).isEqualTo("🫡");
                    assertThat(group[2]).isEqualTo("😥");
                });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
