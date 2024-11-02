package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseViewTest {
    private final InputView view = new PurchaseView();

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @DisplayName("숫자가 아닌 입력값 에러 테스트")
    @Test
    void validateNumericExceptionTest() {
        System.setIn(IoMock.consoleReadline("1,2,c,3,4"));

        Assertions.assertThatThrownBy(() -> view.read())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열 입력 시 에러 테스트")
    @Test
    void validateEmptryExceptionTest() {
        System.setIn(IoMock.consoleReadline("\n"));

        Assertions.assertThatThrownBy(() -> view.read())
                .isInstanceOf(IllegalArgumentException.class);
    }
}