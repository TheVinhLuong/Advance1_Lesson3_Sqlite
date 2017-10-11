package com.example.android.recyclerviewexample.sqlite.screen.wordList;

import com.example.android.recyclerviewexample.sqlite.data.model.Word;
import com.example.android.recyclerviewexample.sqlite.screen.BasePresenter;
import com.example.android.recyclerviewexample.sqlite.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface WordListContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        public void changeDataSet(List<Word> words);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void onItemWordListClicked(Word word);
    }
}
