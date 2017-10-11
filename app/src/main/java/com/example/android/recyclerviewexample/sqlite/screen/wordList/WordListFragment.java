package com.example.android.recyclerviewexample.sqlite.screen.wordList;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android.recyclerviewexample.R;
import com.example.android.recyclerviewexample.databinding.FragmentWordListBinding;
import com.example.android.recyclerviewexample.sqlite.data.DatabaseHandler;
import com.example.android.recyclerviewexample.sqlite.data.model.Word;
import com.example.android.recyclerviewexample.sqlite.screen.BaseFragment;
import java.util.ArrayList;

/**
 * WordList Screen.
 */
public class WordListFragment extends BaseFragment {
    private WordListContract.ViewModel mViewModel;
    private WordListAdapter mWordListAdapter;
    private DatabaseHandler mDatabaseHandler;

    public WordListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Word> words = new ArrayList<>();
        mDatabaseHandler = new DatabaseHandler(getActivity());
        mWordListAdapter = new WordListAdapter(getActivity(), words);
        mViewModel = new WordListViewModel(mWordListAdapter);
        WordListContract.Presenter presenter = new WordListPresenter(mViewModel, mDatabaseHandler);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        FragmentWordListBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_word_list, container, false);
        binding.setViewModel((WordListViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
