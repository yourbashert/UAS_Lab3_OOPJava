import java.time.LocalDate;

class MenstrualHealthChecker {
    private MenstrualHistory menstrualHistory;

    //CONSTRUCTOR
    public MenstrualHealthChecker(MenstrualHistory menstrualHistory) {
        this.menstrualHistory = menstrualHistory;
    }

    //METHOD VOID
    public void checkMenstrualHealth() {
        LocalDate[] periodDates = menstrualHistory.getPeriodDates();
        int numberOfPeriods = menstrualHistory.getNumberOfPeriods();

        if (numberOfPeriods < 3) {
            System.out.println("Riwayat periode belum cukup untuk memprediksi kesehatan menstruasi.");
            return;
        }

        boolean isRegularCycle = true;
        int averageCycleLength = 0;
        int cycleLengthSum = 0;

        // Menghitung rata-rata panjang siklus
        for (int i = 1; i < numberOfPeriods; i++) {
            int cycleLength = (int) periodDates[i - 1].until(periodDates[i]).getDays();
            cycleLengthSum += cycleLength;
        }

        //OPERASI MATEMATIKA
        averageCycleLength = cycleLengthSum / (numberOfPeriods - 1);

        // Mengecek apakah setiap siklus memiliki panjang yang mendekati rata-rata
        for (int i = 1; i < numberOfPeriods; i++) {
            int cycleLength = (int) periodDates[i - 1].until(periodDates[i]).getDays();
            int difference = Math.abs(cycleLength - averageCycleLength);
            if (difference > 2) {
                isRegularCycle = false;
                break;
            }
        }

        //SELECTION
        if (isRegularCycle) {
            System.out.println("Berdasarkan riwayat periode menstruasi yang anda masukkan: Siklus Teratur.");
        } else {
            System.out.println("Berdasarkan riwayat periode menstruasi yang anda masukkan: Siklus Tidak Teratur.");
        }
    }
}
