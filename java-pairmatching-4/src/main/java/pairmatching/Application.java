package pairmatching;

import pairmatching.controller.MatcherController;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        String backendCrewSource = "src/main/resources/backend-crew.md";
        String frontendCrewSource = "src/main/resources/frontend-crew.md";
        MatcherController matcherController = new MatcherController();
        matcherController.start(backendCrewSource, frontendCrewSource);
    }
}
