package Wordy;

import Wordy.Entities.Word;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseInitializer {
    public static void initialize(ConnectionSource connectionSource) throws Exception {
        TableUtils.createTableIfNotExists(connectionSource, Word.class);
    }
}
