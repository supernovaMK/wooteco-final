package oncall.controller;

import oncall.model.ChillPerson;
import oncall.model.CommonPerson;
import oncall.model.GiveDayProcessor;
import oncall.validator.DateValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class WorkController {
    private CommonPerson commonPerson;
    private ChillPerson chillPerson;

    private String date;

    public void start() {
        date = getDate();

        getPersons();

        giveProcess();
    }

    private void giveProcess() {
        GiveDayProcessor giveDayProcessor = new GiveDayProcessor(date, commonPerson.getPersons(),
                chillPerson.getChillPersons());

        OutputView.displayResult(giveDayProcessor.getMothData());
    }

    private void getPersons() {
        while (true) {
            try {
                OutputView.displayCommonPersonInputMessage();
                String userInput = InputView.getCommonPersons();
                commonPerson = new CommonPerson(userInput);

                OutputView.displayChillPersonInputMessage();
                String chillUserInput = InputView.getCommonPersons();
                chillPerson = new ChillPerson(chillUserInput, commonPerson.getPersons());

                return;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private String getDate() {
        while (true) {
            try {
                OutputView.displayGetDateMessage();
                DateValidator dateValidator = new DateValidator();
                String input = InputView.getDate();
                dateValidator.validateDate(input);
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}
