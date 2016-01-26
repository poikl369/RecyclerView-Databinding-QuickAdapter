package rdq.org.recycleview_databinding_quickadapter.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyun on 15/12/18.
 */
public abstract class ListViewDataBindingQuickAdapter<D, B extends ViewDataBinding> extends BaseAdapter {

    private List<D> list = new ArrayList<>();

    private Context context;

    private int layoutId;


    public ListViewDataBindingQuickAdapter(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
    }

    public void clear(){
        this.list.clear();
        this.notifyDataSetChanged();
    }

    public void addAll(List<D> list) {
        this.list.clear();
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    public void addAllNotClear(List<D> list) {
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    public void add(D item) {
        this.list.add(item);
        this.notifyDataSetChanged();
    }

    public void removeItem(int position){
        this.list.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    public D getItemById(int position){
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            View view = LayoutInflater.from(context).inflate(layoutId, null);
            B binding = DataBindingUtil.bind(view);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        }
        convert(convertView, list.get(position), (B) convertView.getTag());
        return convertView;
    }

    protected abstract void convert(View convertView, D item, B binding);
}
