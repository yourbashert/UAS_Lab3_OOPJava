public class Main {
    public static void main(String[] args) {
        int jumlah = 10;
        Thread thread = new Thread() {
            public void run() {
                try {
                    int angka = 1;
                    for (int i = 1; i <= jumlah; i++) {
                        System.out.println("U" + i + " : " + angka);
                        angka += 2; // Operasi aritmatika (penambahan 2)
                        sleep(1000); // Waktu Pending
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }
}