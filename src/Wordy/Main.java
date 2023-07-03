package Wordy;

import Wordy.Entities.Word;
import Wordy.Repositories.WordRepository;
import com.j256.ormlite.support.ConnectionSource;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        ConnectionSource connectionSource = DatabaseManager.getConnection();
        WordRepository wordRepository = new WordRepository(connectionSource);

        Word word = new Word("Probando 14");

        wordRepository.create(word);

//        Word word = wordRepository.find(1);
//
//        word.setValue("Hello World! x");
//
//        wordRepository.update(word);

        List<Word> words = wordRepository.all();

        for (Word w : words) {
            System.out.println(w.getId() + "-" + w.getValue());
        }

        connectionSource.close();
    }
}
