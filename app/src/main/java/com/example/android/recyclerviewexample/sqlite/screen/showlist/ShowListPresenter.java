package com.example.android.recyclerviewexample.sqlite.screen.showlist;


import android.util.Log;
import com.example.android.recyclerviewexample.sqlite.data.model.Word;

/**
 * Listens to user actions from the UI ({@link ShowListActivity}), retrieves the data and updates
 * the UI as required.
 */
final class ShowListPresenter implements ShowListContract.Presenter {
    private static final String TAG = ShowListPresenter.class.getSimpleName();

    private final ShowListContract.ViewModel mViewModel;

    public ShowListPresenter(ShowListContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onItemWordClicked(Word word) {
        Log.d(TAG, "onItemClicked: " + word.getWord());
    }
}
