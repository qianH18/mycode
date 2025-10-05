package com.android.keepaccounts;

import android.support.v4.content.ContextCompat;

/**
 * 添加收入记录的Fragment
 */
public class IncomeRecordFragment extends BaseRecordFragment {

    public IncomeRecordFragment() {
        // Required empty public constructor
    }

    @Override
    public void initSettings() {
        moneyText.setTextColor(ContextCompat.getColor(getContext(), R.color.colorRed));
        isExpense = false;
        typeArray = getResources()
                .getStringArray(R.array.default_income_type);
        int choice = Integer.parseInt((String) prefs.get("default_income_type", "0"));
        classifyText.setText(typeArray[choice]);
        if (isEditMode) {
            setItemData(moneySaved, classifySaved, timeSaved, remarkSaved);
        }
    }
}
