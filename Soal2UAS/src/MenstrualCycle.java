import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MenstrualCycle {
    private LocalDate startDate;
    private int cycleDuration;

    //CONSTRUCTOR
    public MenstrualCycle(LocalDate startDate, int cycleDuration) {

        //KEYWORD THIS
        this.startDate = startDate;
        this.cycleDuration = cycleDuration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getCycleDuration() {
        return cycleDuration;
    }

    //GETTER METHOD
    public LocalDate getNextPeriodDate() {
        return startDate.plusDays(cycleDuration);
    }

    //OVERLOADING METHOD - POLYMORPHISM
    public LocalDate getNextPeriodDate(LocalDate referenceDate) {
        long daysUntilNextPeriod = ChronoUnit.DAYS.between(referenceDate, getNextPeriodDate());
        return referenceDate.plusDays(daysUntilNextPeriod);
    }

    //METHOD NON-VOID
    public long getDaysUntilNextPeriod() {
        LocalDate currentDate = LocalDate.now();
        return ChronoUnit.DAYS.between(currentDate, getNextPeriodDate());
    }

    //INNER CLASS
    public class CycleInfo {
        private LocalDate startDate;
        private int cycleDuration;

        public CycleInfo(LocalDate startDate, int cycleDuration) {
            this.startDate = startDate;
            this.cycleDuration = cycleDuration;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public int getCycleDuration() {
            return cycleDuration;
        }

        public LocalDate getNextPeriodDate() {
            return startDate.plusDays(cycleDuration);
        }
    }
}
