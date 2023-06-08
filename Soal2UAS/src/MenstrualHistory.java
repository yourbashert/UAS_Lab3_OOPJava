import java.time.LocalDate;
import java.util.Arrays;

//INHERITANCE
class MenstrualHistory extends MenstrualCycle {
    //ENKAPSULASI
    private LocalDate[] periodDates;
    private int numberOfPeriods;

    //CONSTRUCTOR
    public MenstrualHistory(LocalDate startDate, int cycleDuration) {
        super(startDate, cycleDuration);

        //KEYWORD THIS
        this.periodDates = new LocalDate[100];
        this.numberOfPeriods = 0;
    }

    public void addPeriodDate(LocalDate periodDate) {
        periodDates[numberOfPeriods] = periodDate;
        numberOfPeriods++;
    }

    //IMPLEMENTASI ARRAY & ENKAPSULASI
    public LocalDate[] getPeriodDates() {
        return Arrays.copyOf(periodDates, numberOfPeriods);
    }

    //METHOD NON-VOID & ENKAPSULASI
    public int getNumberOfPeriods() {
        return numberOfPeriods;
    }
}

