package com.example.android.recyclerviewexample.sqlite.screen.showlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.android.recyclerviewexample.R;
import com.example.android.recyclerviewexample.sqlite.screen.BaseActivity;
import com.example.android.recyclerviewexample.databinding.ActivityShowListBinding;

/**
 * RecyclerView Screen.
 */
public class ShowListActivity extends BaseActivity {
    private static final String TAG = ShowListActivity.class.getSimpleName();
    private ShowListViewModel mViewModel;
    private ShowListContract.Presenter presenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ShowListViewModel();
        presenter =
                new ShowListPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        ActivityShowListBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_show_list);
        binding.setViewModel(mViewModel);
        binding.setViewPagerAdapter(new ShowListPagerAdapter(getFragmentManager()));
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
