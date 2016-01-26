package rdq.org.recycleview_databinding_quickadapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rdq.org.recycleview_databinding_quickadapter.adapter.RecyclerViewQuickAdapter;
import rdq.org.recycleview_databinding_quickadapter.databinding.ActivityRecyclerViewBinding;
import rdq.org.recycleview_databinding_quickadapter.databinding.LayoutTextItemBinding;

/**
 * Created by liuyun on 16/1/26.
 */
public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewQuickAdapter.OnItemClickListener {

    private ActivityRecyclerViewBinding binding;

    private RecyclerViewQuickAdapter<String, LayoutTextItemBinding> adapter;

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.addItemDecoration(new DividerGridDecoration(this));
        adapter = new RecyclerViewQuickAdapter<String, LayoutTextItemBinding>(this, R.layout.layout_text_item) {
            @Override
            protected void dataBinding(String item, LayoutTextItemBinding binding) {
                binding.setName(item);
            }
        };
        binding.recyclerView.setAdapter(adapter);
        initData();
        adapter.addAll(list);
        adapter.setOnItemClickListener(this);
    }

    private void initData() {
        list.add("java");
        list.add("c++");
        list.add("c");
        list.add("ruby");
        list.add("python");
        list.add("object-c");
        list.add("VB");
        list.add("c#");
        list.add("F#");
        list.add("Lisp");
        list.add("js");
    }

    @Override
    public void onItemClick(View view, int position) {

        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_LONG).show();
    }
}
