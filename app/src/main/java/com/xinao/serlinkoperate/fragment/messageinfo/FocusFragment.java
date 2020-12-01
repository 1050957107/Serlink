package com.xinao.serlinkoperate.fragment.messageinfo;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseFragment;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

/**
 * @date：2020/12/1
 * @describe：
 * @author：DanDan
 */
public class FocusFragment extends BaseFragment<Presenter> implements IBaseView {
    @Override
    protected void refreshData() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_focus;
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
