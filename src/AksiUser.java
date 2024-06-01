import java.util.Scanner;

public class AksiUser extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi User:");
        System.out.println("1. Pesan Film");
        System.out.println("2. Lihat Saldo");
        System.out.println("3. Lihat List Film");
        System.out.println("4. Lihat Pesanan");
        System.out.println("5. Logout");
        System.out.println("6. Tutup Aplikasi");
    }

    @Override
    public void keluar() {
        Akun.logout();
        System.out.println("Anda telah logout.");
    }

    @Override
    public void tutupAplikasi() {
        System.out.println("Aplikasi ditutup.");
        System.exit(0);
    }

    @Override
    public void lihatListFilm() {
        // Implementasi melihat list film
        // Menampilkan daftar film yang tersedia
        System.out.println("Daftar Film: ");
        for (Film film : Film.getFilms().values()) {
            System.out.println("Film: " + film.getName() + " - Deskripsi: " + film.getDescription() + 
                           " - Harga: " + film.getPrice() + " - Stok: " + film.getStock() + "\n");
    }
    }

    public void lihatSaldo() {
        // Implementasi lihat Saldo
        // Menampilkan saldo pengguna saat ini
        System.out.println("Saldo Anda: " + Akun.getCurrentUser().getSaldo());
    }

    public void pesanFilm() {
        // Implementasi pemesanan film
        // Proses pemesanan tiket film
        Scanner input = new Scanner(System.in);

        // Meminta nama film yang ingin dipesan
        System.out.print("Masukkan nama film yang ingin dipesan: ");
        String namaFilm = input.nextLine();
        Film film = Film.getFilms().get(namaFilm);

        // Memeriksa apakah film tersedia
        if (film == null) {
            System.out.println("Film yang dicari tidak ditemukan.");
            return;
        }

        // Meminta jumlah tiket yang ingin dipesan
        System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = input.nextInt();

        // Menghitung total harga tiket
        double totalHarga = jumlahTiket * film.getPrice();

        // Memeriksa ketersediaan stok dan saldo pengguna
        if (film.getStock() < jumlahTiket) {
            System.out.println("Stok tiket tidak mencukupi.");
        } else if (Akun.getCurrentUser().getSaldo() < totalHarga) {
            System.out.println("Saldo tidak mencukupi, saldo Anda saat ini: " + Akun.getCurrentUser().getSaldo() + "\n");
        } else {
            // Mengurangi stok tiket, mengurangi saldo pengguna, dan menambahkan pesanan
            film.setStock(film.getStock() - jumlahTiket);
            Akun.getCurrentUser().setSaldo(Akun.getCurrentUser().getSaldo() - totalHarga);
            Akun.getCurrentUser().addPesanan(film, jumlahTiket);

            // Menampilkan informasi pemesanan
            System.out.println("Harga satuan tiket: " + film.getPrice());
            System.out.println("Total harga: " + totalHarga);
            System.out.println("Tiket berhasil dipesan.");
        }
    }

    public void lihatPesanan() {
        // Implementasi melihat pesanan
        // Menampilkan daftar pesanan pengguna
        if (Akun.getCurrentUser().getPesanan().isEmpty()) {
            // Jika belum ada pesanan
            System.out.println("Anda belum pernah melakukan pemesanan.");
        } else {
            // Menampilkan semua pesanan yang sudah dilakukan
            for (Pesanan pesanan : Akun.getCurrentUser().getPesanan().values()) {
                System.out.println("Film: " + pesanan.getFilm().getName() + 
                                   " - Jumlah: " + pesanan.getKuantitas() + 
                                   " - Total Harga: " + (pesanan.getKuantitas() * pesanan.getFilm().getPrice()));
            }
        }
    }
}
