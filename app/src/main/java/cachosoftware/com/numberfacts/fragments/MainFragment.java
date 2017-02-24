package cachosoftware.com.numberfacts.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;

import cachosoftware.com.numberfacts.R;
import cachosoftware.com.numberfacts.utils.AutoResizeTextView;

/**
 * Created by a Monkey on 14/1/17.
 */

public class MainFragment extends Fragment implements MainView {

    private AutoResizeTextView text;


    private int mDay;
    private ProgressBar loading;
    private int mMonth;

    private MainPresenter mPresenter;

    private Button goFact;
    private Button goYear;
    private Button goMath;
    private Button goDate;
    private Button launchCalendar;
    private EditText editText;

    public static MainFragment newInstance() {
        MainFragment f = new MainFragment();
        return f;
    }

    private void getUI(View view) {
        text = (AutoResizeTextView) view.findViewById(R.id.text);
        goFact = (Button) view.findViewById(R.id.go_numberfact);
        goYear = (Button) view.findViewById(R.id.go_yearfact);
        goMath = (Button) view.findViewById(R.id.go_mathfact);
        loading = (ProgressBar) view.findViewById(R.id.loading);
        goDate = (Button) view.findViewById(R.id.go_date);
        launchCalendar = (Button) view.findViewById(R.id.launch_calendar);
        editText = (EditText) view.findViewById(R.id.et_numberfact);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUI(view);
        mPresenter = new MainPresenter(this);

        goFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyEtEmpty()) {
                    mPresenter.getRandomTrivia();
                } else {
                    mPresenter.getTriviaFromNumer(Integer.valueOf(editText.getText().toString()));
                }
            }
        });

        launchCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                java.util.Calendar newCalendar = java.util.Calendar.getInstance();
                DatePickerDialog fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mDay = dayOfMonth;
                        mMonth = monthOfYear;
                        editText.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear));
                    }

                }, newCalendar.get(java.util.Calendar.YEAR), newCalendar.get(java.util.Calendar.MONTH), newCalendar.get(java.util.Calendar.DAY_OF_MONTH));
                fromDatePickerDialog.show();

            }
        });

        goDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDay == 0 && mMonth == 0) {
                    mPresenter.getRandomDate();
                } else {
                    mPresenter.getDate(mDay, mMonth);
                }
            }
        });


        goMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyEtEmpty()) {
                    mPresenter.getRandomMath();
                } else {
                    mPresenter.getMathFact(Integer.valueOf(editText.getText().toString()));
                }
            }
        });

        goYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyEtEmpty()) {
                    mPresenter.getRandomYear();
                } else {
                    mPresenter.getYearFact(Integer.valueOf(editText.getText().toString()));
                }
            }
        });

    }

    private boolean isMyEtEmpty() {
        return editText.getText().toString().isEmpty();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            loading.setVisibility(View.VISIBLE);
        } else {
            loading.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void resetData() {
        mDay = 0;
        mMonth = 0;
        editText.setText("");

    }

    @Override
    public void setFact(String fact) {
        text.setText(fact);
    }
}
