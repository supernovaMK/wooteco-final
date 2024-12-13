package pairmatching.controller;

import java.util.List;
import pairmatching.file.CrewFileReader;
import pairmatching.model.BackendCrews;
import pairmatching.model.FrontendCrews;
import pairmatching.view.InputView;
import pairmatching.view.Outview;

public class MatcherController {
    private CrewFileReader crewFileReader = new CrewFileReader();
    private BackendCrews backendCrews;
    private FrontendCrews frontendCrews;

    public void start(String backendCrewSource, String frontendCrewSource) {
        backendCrews = new BackendCrews(crewFileReader.readFile(backendCrewSource));
        frontendCrews = new FrontendCrews(crewFileReader.readFile(frontendCrewSource));

        matcherStart();
    }

    private void matcherStart() {
        while (true) {
            try {
                Outview.displayStartingMessage();
                String input = InputView.getUserInput();
                if (input.equals("Q")) {
                    break;
                }
                pariProcess(input);
            } catch (IllegalArgumentException e) {
                Outview.displayErrorMessage(e.getMessage());
            }
        }
    }

    private void pariProcess(String input) {
        if (input.equals("1")) {
            pairmatchingProcess();
        }
        if (input.equals("2")) {
            parifindingProcess();
        }
        if (input.equals("3")) {
            pairClearProcess();
        }
    }

    private void pairClearProcess() {
    }

    private void parifindingProcess() {
        Outview.displayCourses();
        List<String> list = (InputView.getType());
        if (list.get(0).equals("백엔드")) {
            System.out.println("페어 매칭 결과입니다.");
            for (String[] li : backendCrews.getMatchedList().get(list.get(2)).getMatchedCrews()) {
                System.out.println(li[0] + " | " + li[1]);
            }
        }
        if (list.get(0).equals("프론트엔드")) {
            System.out.println("페어 매칭 결과입니다.");
            for (String[] li : frontendCrews.getMatchedList().get(list.get(2)).getMatchedCrews()) {
                System.out.println(li[0] + " : " + li[1]);
            }
        }
    }

    private void pairmatchingProcess() {
        while (true) {
            try {
                Outview.displayCourses();
                List<String> list = (InputView.getType());
                if (list.get(0).equals("백엔드")) {
                    backendCrews.matchCrews(list.get(2).trim(), list.get(1).trim());
                    System.out.println("페어 매칭 결과입니다.");
                    for (String[] li : backendCrews.getMatchedList().get(list.get(2)).getMatchedCrews()) {
                        System.out.println(li[0] + " : " + li[1]);
                    }
                }
                if (list.get(0).equals("프론트엔드")) {
                    frontendCrews.matchCrews(list.get(2).trim(), list.get(1).trim());
                    System.out.println("페어 매칭 결과입니다.");
                    for (String[] li : frontendCrews.getMatchedList().get(list.get(2)).getMatchedCrews()) {
                        System.out.println(li[0] + " : " + li[1]);
                    }
                }
                break;
            } catch (IllegalArgumentException e) {
                Outview.displayErrorMessage(e.getMessage());
            }
        }
    }
}
