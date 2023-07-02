/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wordy;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/**
 *
 * @author pipe
 */
public class DatabaseManager {
    private static final String DATABASE_NAME = "wordy.db";
    private static final String DATABASE_URL = "jdbc:sqlite:" + getDatabasePath();
    
    private static String getDatabasePath() {
        String projectDir = System.getProperty("user.dir");
        
        return projectDir + "/" + DATABASE_NAME;
    }

    public static ConnectionSource getConnection() throws Exception {
        ConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);

        DatabaseInitializer.initialize(connectionSource);

        return connectionSource;
    }
}
