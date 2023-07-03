/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wordy.Repositories;

import Wordy.Entities.Word;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pipe
 */
public class WordRepository {
    private final Dao<Word, Integer> wordDao;
    
    public WordRepository(ConnectionSource connectionSource) throws SQLException {
        wordDao = DaoManager.createDao(connectionSource, Word.class);
    }
    
    public void create(Word word) throws SQLException {
        wordDao.create(word);
    }

    public void update(Word word) throws SQLException {
        wordDao.update(word);
    }

    public void delete(Word word) throws SQLException {
        wordDao.delete(word);
    }

    public Word find(int id) throws SQLException {
        return wordDao.queryForId(id);
    }

    public Word findByValue(String value) throws SQLException {
        return wordDao.queryBuilder().where().eq("value", value).queryForFirst();
    }

    public List<Word> all() throws SQLException {
        return wordDao.queryForAll();
    }

    public Word random() throws SQLException {
        return wordDao.queryBuilder().orderByRaw("RANDOM()").queryForFirst();
    }
}
