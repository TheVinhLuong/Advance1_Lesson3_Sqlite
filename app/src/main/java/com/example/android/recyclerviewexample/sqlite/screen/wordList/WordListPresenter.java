package com.example.android.recyclerviewexample.sqlite.screen.wordList;

import android.util.Log;
import com.example.android.recyclerviewexample.sqlite.data.DatabaseHandler;
import com.example.android.recyclerviewexample.sqlite.data.model.Word;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link WordListFragment}), retrieves the data and updates
 * the UI as required.
 */
final class WordListPresenter implements WordListContract.Presenter {
    private static final String TAG = WordListPresenter.class.getSimpleName();
    private final WordListContract.ViewModel mViewModel;
    private final DatabaseHandler mDatabaseHandler;
    
    public WordListPresenter(WordListContract.ViewModel viewModel, 
            DatabaseHandler databaseHandler) {
        mViewModel = viewModel;
        mDatabaseHandler = databaseHandler;
    }

    @Override
    public void onStart() {
        if(mDatabaseHandler != null){
            mDatabaseHandler.resetTable();
            mDatabaseHandler.addWord(new Word("a"));
            mDatabaseHandler.addWord(new Word("b"));
            mDatabaseHandler.addWord(new Word("c"));
            List<Word> words = mDatabaseHandler.getAllWords();
            mViewModel.changeDataSet(words);
        }
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onItemWordListClicked(Word word) {
        Log.d(TAG, word.getWord() + " " +
        WordListPresenter.class.getName());
    }
}
