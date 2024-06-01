import java.util.Scanner;

public class AksiAdmin extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi Admin:");
        System.out.println("1. Tambah Film");
        System.out.println("2. Lihat List Film");
        System.out.println("3. Logout");
        System.out.println("4. Tutup Aplikasi");
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
        System.out.println("Daftar Film: ");
        for(Film film : Film.getFilms().values()){
            System.out.println("Film: " +  film.getName() + "- Deskripsi: " +  film.getDescription() +  " - Harga: " + film.getPrice() + " - Stok: " + film.getStock());
        }
        // Menampilkan daftar film
    }

    public void tambahFilm() {
        // Implementasi menambahkan film
        Scanner input = new Scanner(System.in);
        System.out.print("Nama Film: ");
        String name = input.nextLine();
        System.out.print("Deskripsi Film: ");
        String description = input.nextLine();
        System.out.print("Harga Tiket: ");
        double price = input.nextDouble();
        System.out.print("Stok Tiket: ");
        int stock = input.nextInt();
        Film.addFilm(name, description, price, stock);
        // Metode untuk menambahkan film baru
    }
}
