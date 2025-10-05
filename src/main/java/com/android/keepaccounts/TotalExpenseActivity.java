package com.android.keepaccounts;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.keepaccounts.adapters.AccountRecyclerViewAdapter;
import com.android.keepaccounts.bean.db.AccountInfo;
import com.android.keepaccounts.constant.Type;
import com.android.keepaccounts.utils.AccountDAO;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

//本月总支出
public class TotalExpenseActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private AccountRecyclerViewAdapter accountRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_expense);
        setToolbar(R.id.toolbar_settings, true);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<AccountInfo> infoList =
                AccountDAO.quickFind(Type.ACCOUNT_THIS_MONTH);

        List<AccountInfo> newList =new ArrayList<>();

        for (int i = 0; i < infoList.size(); i++) {
            AccountInfo info = infoList.get(i);
            if (info.isExpense()){
                newList.add(info);
            }
        }

        accountRecyclerViewAdapter = new AccountRecyclerViewAdapter(R.layout.account_list_item,newList);
        recyclerView.setAdapter(accountRecyclerViewAdapter);
    }
}
