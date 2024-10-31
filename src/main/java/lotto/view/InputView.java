package lotto.view;

import static lotto.constant.Message.PURCHASE_AMOUNT_INPUT_GUIDE;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputModel;

public class InputView {

    public void printPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
    }

    public String getInput() {
        String input = Console.readLine();
        InputModel inputModel = new InputModel(input);
        return inputModel.getInput();
    }
}
