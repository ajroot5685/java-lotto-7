package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void init() {
        this.inputValidator = new InputValidator();
    }

    @Test
    void validateInputIsEmpty_null이_들어오면_에러를_발생시킨다() {
        // given
        String input = null;

        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateInputIsEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.INPUT_EMPTY);
    }

    @Test
    void validateInputIsEmpty_빈_문자열이_들어오면_에러를_발생시킨다() {
        // given
        String input = "";

        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateInputIsEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.INPUT_EMPTY);
    }

    @Test
    void validateInputIsEmpty_빈_문자열이_아니면_아무_일이_일어나지_않는다() {
        // given
        String input = "문자";

        // when

        // then
        Assertions.assertThatCode(() -> inputValidator.validateInputIsEmpty(input))
                .doesNotThrowAnyException();
    }

    @Test
    void validateValidCharacter_숫자와_쉼표_외에_다른_문자가_들어오면_에러를_발생시킨다() {
        // given
        String input = "1,2,#,4,5,6";

        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateValidCharacter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.WINNER_NUMBER_INPUT_INVALID_CHARACTER);
    }

    @Test
    void validateValidCharacter_숫자에_소수가_들어오면_에러를_발생시킨다() {
        // given
        String input = "1,2,#,4,5,6.3";

        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateValidCharacter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.WINNER_NUMBER_INPUT_INVALID_CHARACTER);
    }

    @Test
    void validateValidCharacter_자연수와_쉼표만_들어오면_아무_일이_일어나지_않는다() {
        // given
        String input = "1,";

        // when

        // then
        Assertions.assertThatCode(() -> inputValidator.validateValidCharacter(input))
                .doesNotThrowAnyException();
    }
}