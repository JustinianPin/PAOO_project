package WilliamTheKnight;

import WilliamTheKnight.Items.Scor;

import java.sql.*;

public class Database {
    private static Database instance;
    private Connection connection;
    private Statement statement;

    private Database() {
        try {
            // Stabilirea conexiunii cu baza de date
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite: tabel.db");
            statement = connection.createStatement();

            // Crearea tabelului (dacă nu există deja)
            String createTableQuery = "CREATE TABLE IF NOT EXISTS tabel (scor INT, indexul INT)";
            statement.executeUpdate(createTableQuery);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public void adaugaInregistrare(int scor) {
        try {

            // Inserarea unei înregistrări noi în tabel
            String insertQuery = "INSERT INTO tabel (scor, indexul) VALUES (" + scor + ", " + 0 + ")";
            System.out.println("Din Database: adaugaInregistare: " + scor);
            scor += 10;
            statement.executeUpdate(insertQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afiseazaInregistrari() {
        try {
            // Selectarea și afișarea tuturor înregistrărilor din tabel
            String selectQuery = "SELECT * FROM tabel";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int scor = resultSet.getInt("scor");
                int index = resultSet.getInt("indexul");
                System.out.println("Scor: " + scor + ", Index: " + index);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inchideConexiune() {
        try {
            // Închiderea conexiunii și eliberarea resurselor
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
