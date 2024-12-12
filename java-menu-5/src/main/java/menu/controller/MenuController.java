package menu.controller;

import menu.model.Coach;
import menu.model.Coaches;
import menu.model.MenuChooser;
import menu.view.InputView;
import menu.view.OutView;

public class MenuController {
    private Coaches coaches;
    private MenuChooser menuChooser;


    public void start() {
        getCoachNames();
        getDislikeFood();
        chooseMenuProcess();
        displayResult();
    }

    private void chooseMenuProcess() {
        menuChooser = new MenuChooser(coaches.getCoachList());
    }

    private void getDislikeFood() {

        for (Coach coach : coaches.getCoachList()) {
            while (true) {
                try {
                    OutView.displayDislikeFoodMessage(coach.getName());
                    coach.dislikeFood(InputView.getDislikeFood());
                    break;
                } catch (IllegalArgumentException e) {
                    OutView.displayErrorMessage(e.getMessage());
                }
            }
        }
    }

    private void getCoachNames() {
        OutView.displayStartingMessage();
        while (true) {
            try {
                OutView.displayCoachNameMessage();
                coaches = new Coaches(InputView.getCoachNames());
                break;
            } catch (IllegalArgumentException e) {
                OutView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private void displayResult() {
        OutView.displayResultInfoMessage();
        OutView.displayCategoriesMessage(menuChooser.getSelectedCategories());
        OutView.displayCoches(coaches.getCoachList());
    }
}
