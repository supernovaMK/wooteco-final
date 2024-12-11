package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oncall.enums.ChillDay;
import oncall.enums.Months;

public class GiveDayProcessor {
    private List<String> days = Arrays.asList(new String[]{"일", "월", "화", "수", "목", "금", "토"});
    private List<Object[]> mothData = new ArrayList<>();

    private int startingIndex;
    private Months month;

    private List<Integer> chillDay;

    private int commonWorkerIndex;
    private int chillWorkerIndex;
    private String beforeWorkerName;

    private String sorryCommonWorker;
    private String sorryChillWorker;
    private List<String> chillPersonWorkers;
    private List<String> commonPersonWorkers;

    public GiveDayProcessor(String date, List<String> commonPersons, List<String> chillPersons) {
        this.chillPersonWorkers = chillPersons;
        this.commonPersonWorkers = commonPersons;
        List<String> list = Arrays.asList(date.split(","));
        month = Months.findMonth(Integer.parseInt(list.get(0)));
        startingIndex = days.indexOf(list.get(1));

        chillDay = ChillDay.giveChillDays(Integer.parseInt(list.get(0)));
        int index = startingIndex;
        commonWorkerIndex = 0;
        chillWorkerIndex = 0;
        beforeWorkerName = null;

        sorryChillWorker = null;
        sorryCommonWorker = null;
        for (int i = 1; i <= month.getDays(); i++) {

            String dayName = days.get(index);

            String workerName = getWorkerName(index, i);
            beforeWorkerName = workerName;
            boolean whoo = false;
            if ((index != 0 && index != 6) && chillDay != null && chillDay.contains(i)) {
                whoo = true;

            }
            mothData.add(new Object[]{Integer.toString(i), dayName, workerName, whoo, list.get(0)});

            if (index == 0 || index == 6 || (chillDay != null && chillDay.contains(i))) {
                chillWorkerIndex = (chillWorkerIndex + 1) % chillPersonWorkers.size();
            } else {
                commonWorkerIndex = (commonWorkerIndex + 1) % commonPersonWorkers.size();
            }

            index = (index + 1) % days.size();

        }
    }

    private String getWorkerName(int index, int i) {
        if (index == 0 || index == 6 || (chillDay != null && chillDay.contains(i))) {

            if (sorryChillWorker != null) {
                String name = sorryChillWorker;
                sorryChillWorker = null;
                return name;
            }
            if (beforeWorkerName == null) {
                return chillPersonWorkers.get(chillWorkerIndex);
            }
            if (beforeWorkerName.equals(chillPersonWorkers.get(chillWorkerIndex))) {
                sorryChillWorker = chillPersonWorkers.get(chillWorkerIndex);
                return chillPersonWorkers.get((chillWorkerIndex + 1) % chillPersonWorkers.size());
            }
            if (!beforeWorkerName.equals(chillPersonWorkers.get(chillWorkerIndex))) {
                return chillPersonWorkers.get(chillWorkerIndex);
            }
        }
        if (sorryCommonWorker != null) {
            String name2 = sorryCommonWorker;
            sorryCommonWorker = null;
            return name2;
        }
        if (beforeWorkerName == null) {
            return commonPersonWorkers.get(commonWorkerIndex);
        }

        if (!beforeWorkerName.equals(commonPersonWorkers.get(commonWorkerIndex))) {
            return commonPersonWorkers.get(commonWorkerIndex);
        }
        sorryCommonWorker = commonPersonWorkers.get(commonWorkerIndex);
        return commonPersonWorkers.get((commonWorkerIndex + 1) % commonPersonWorkers.size());
    }

    public List<Object[]> getMothData() {
        return mothData;
    }
}
