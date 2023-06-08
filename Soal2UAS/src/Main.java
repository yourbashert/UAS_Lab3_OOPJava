import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("            MENSTRUAL PERIOD TRACKER          ");
        System.out.println("==============================================");
        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal awal menstruasi (YYYY-MM-DD): ");
        String inputStartDate = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(inputStartDate);

        System.out.print("Masukkan durasi siklus menstruasi (dalam hari): ");
        int cycleDuration = scanner.nextInt();

        MenstrualCycle menstrualCycle = new MenstrualCycle(startDate, cycleDuration);
        MenstrualCycle.CycleInfo cycleInfo = menstrualCycle.new CycleInfo(startDate, cycleDuration);
        System.out.println(" ");
        System.out.println("================YOUR INFO=================");
        System.out.println("Tanggal Awal Menstruasi Terakhir: " + cycleInfo.getStartDate());
        System.out.println("Siklus Menstruasi: " + cycleInfo.getCycleDuration());
        System.out.println("Prediksi Tanggal Menstruasi Berikutnya: " + cycleInfo.getNextPeriodDate());

        System.out.println(" ");
        System.out.println("REMINDER");
        System.out.println("Tanggal Menstruasi Anda berikutnya diprediksi akan dimulai dalam: " + menstrualCycle.getDaysUntilNextPeriod() + " hari lagi");
        System.out.println(" ");

        scanner.nextLine(); // Membuang karakter newline yang tersisa

        System.out.println("================MENSTRUAL HISTORY=================");
        System.out.println(" ");
        MenstrualHistory menstrualHistory = new MenstrualHistory(startDate, cycleDuration);
        System.out.print("Masukkan jumlah periode yang ingin ditambahkan: ");
        int numberOfPeriods = scanner.nextInt();

        //LOOPING (PERULANGAN)
        for (int i = 0; i < numberOfPeriods; i++) {

            //EXCEPTION HANDLING
            try{
            System.out.print("Masukkan tanggal periode ke-" + (i + 1) + " (YYYY-MM-DD): ");
            String periodDateString = scanner.next();
            LocalDate periodDate = LocalDate.parse(periodDateString);
            menstrualHistory.addPeriodDate(periodDate);
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan saat memasukkan tanggal periode: " + e.getMessage());
                i--; // Mengulangi iterasi jika terjadi kesalahan
            }
        }

        System.out.println(" ");
        System.out.println("Period History:");
        LocalDate[] periodDates = menstrualHistory.getPeriodDates();
        for (LocalDate date : periodDates) {
            System.out.println(date);
        }

        System.out.println(" ");
        System.out.println("================MENSTRUAL HEALTH=================");
        System.out.println(" ");
        MenstrualHealthChecker healthChecker = new MenstrualHealthChecker(menstrualHistory);
        healthChecker.checkMenstrualHealth();
    }
}