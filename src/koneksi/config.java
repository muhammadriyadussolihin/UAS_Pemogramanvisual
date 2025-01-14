package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class config {
    public static Connection conn;

    public static Connection Conn() {
        try {
            // Gunakan driver MySQL versi baru
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL koneksi
            String url = "jdbc:mysql://localhost:3306/db_javabuku";
            String user = "root";
            String password = "";

            // Buat koneksi
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi berhasil!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection connection = config.Conn();
        if (connection != null) {
            System.out.println("Koneksi ke database berhasil!");
        } else {
            System.out.println("Koneksi ke database gagal!");
        }
    }
}
