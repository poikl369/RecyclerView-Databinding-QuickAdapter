package rdq.org.recycleview_databinding_quickadapter.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyun on 15/12/22.
 */
@SuppressWarnings("ALL")
public abstract class RecyclerViewQuickAdapter<D, B extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private Context context;

    private int layoutId;

    private List<D> list = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    private OnItemLongClickListener onItemLongClickListener;

    public RecyclerViewQuickAdapter(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
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
        this.list.clear();
        this.list.add(item);
        this.notifyDataSetChanged();
    }

    public void removeItem(int position) {
        this.list.remove(position);
        this.notifyDataSetChanged();
    }

    public D getItem(int position) {
        return list.get(position);
    }

    public List<D> getList() {
        return this.list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void addItemByPosition(D item, int position) {
        if (position > list.size()) {
            this.list.clear();
            this.list.add(position, item);
            this.notifyDataSetChanged();
        }

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new RecyclerViewHolder<B>(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(v, position);
            }
        });
        holder.getBinding().getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (null != onItemLongClickListener)
                    onItemLongClickListener.onItemLongClick(v, position);
                return true;
            }
        });
        dataBinding(list.get(position), (B) holder.getBinding());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected abstract void dataBinding(D item, B binding);

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }
}
