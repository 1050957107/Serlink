package com.xinao.serlinkoperate.activity.tool.toolfragment;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseFragment;
import com.xinao.serlinkoperate.base.Presenter;

/**
 * @date：2020/11/28
 * @describe：
 * @author：DanDan
 */
public class ProjectFragment extends BaseFragment {
    @Override
    protected void refreshData() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initPresenter() {
        mPresenter=new Presenter(this);
        mPresenter.init();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void init() {

    }
}
