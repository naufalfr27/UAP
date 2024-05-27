import java.util.Scanner;

public class Main {
    static AksiAdmin aksiAdmin = new AksiAdmin();
    static AksiUser aksiUser = new AksiUser();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        User.addUser("user", "123", false);
        User.addUser("admin", "123", true);

        System.out.println(STR."||\{"=".repeat(40)}||");
        System.out.println(STR."||\{" ".repeat(14)}Bioskop DSI\{" ".repeat(15)}||");
        System.out.println(STR."||\{"=".repeat(40)}||");

        while (true) {
            System.out.println("Silakan login >_<");
            System.out.print("Username: ");
            String username = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();

            User user = authenticate(username, password);

            if (user != null) {
                Akun.login(user);
                System.out.println(STR."Selamat datang \{Akun.getCurrentUser().getUsername()}");
                if (Akun.getCurrentUser().isAdmin()) {
                    handleAksiAdmin();
                } else {
                    handleAksiUser();
                }
            } else {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }
        }
    }

    private static User authenticate(String username, String password) {
        User user = User.getUsers().get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    private static void handleAksiUser() {
        while (true) {
            aksiUser.tampilanAksi();
            switch (scanner.nextInt()) {
                case 1 -> aksiUser.pesanFilm();
                case 2 -> aksiUser.lihatListFilm();
                case 3 -> aksiUser.lihatPesanan();
                case 4 -> {
                    aksiUser.keluar();
                    return;
                }
                case 5 -> aksiUser.tutupAplikasi();
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }

    private static void handleAksiAdmin() {
        while (true) {
            aksiAdmin.tampilanAksi();
            switch (scanner.nextInt()) {
                case 1 -> aksiAdmin.tambahFilm();
                case 2 -> aksiAdmin.lihatListFilm();
                case 3 -> {
                    aksiAdmin.keluar();
                    return;
                }
                case 4 -> aksiAdmin.tutupAplikasi();
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }
}
