package rdq.org.recycleview_databinding_quickadapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import rdq.org.recycleview_databinding_quickadapter.adapter.ListViewDataBindingQuickAdapter;
import rdq.org.recycleview_databinding_quickadapter.databinding.ActivityListViewBinding;
import rdq.org.recycleview_databinding_quickadapter.databinding.LayoutTextItemBinding;

/**
 * Created by liuyun on 16/1/26.
 */
public class ListViewActivity extends AppCompatActivity {

    private ActivityListViewBinding binding;

    private ListViewDataBindingQuickAdapter<String, LayoutTextItemBinding> adapter;

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_view);
        adapter = new ListViewDataBindingQuickAdapter<String, LayoutTextItemBinding>(this, R.layout.layout_text_item) {
            @Override
            protected void convert(View convertView, String item, LayoutTextItemBinding binding) {
                binding.setName(item);
            }
        };
        initData();
        binding.listView.setAdapter(adapter);
        adapter.addAll(list);
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
}
