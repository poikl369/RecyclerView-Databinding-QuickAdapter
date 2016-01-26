package rdq.org.recycleview_databinding_quickadapter.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liuyun on 15/12/22.
 */
public class RecyclerViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    B binding;

    public RecyclerViewHolder(View view) {
        super(view);
        binding = DataBindingUtil.bind(view);
    }

    public B getBinding() {
        return binding;
    }

}
