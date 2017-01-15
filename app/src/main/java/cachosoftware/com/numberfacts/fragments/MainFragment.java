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

import cachosoftware.com.numberfacts.R;
import cachosoftware.com.numberfacts.data.DataHandler;
import cachosoftware.com.numberfacts.data.ServiceListener;
import cachosoftware.com.numberfacts.model.NumberFact;
import cachosoftware.com.numberfacts.utils.AutoResizeTextView;

/**
 * Created by a Monkey on 14/1/17.
 */

public class MainFragment extends Fragment {

    private AutoResizeTextView text;


    private int day;
    private int month;

    private Button goFact;
    private Button goYear;
    private Button goMath;
    private Button goDate;
    private Button launchCalendar;
    private EditText editText;

    public static MainFragment newInstance(){
        MainFragment f = new MainFragment();
        return f;
    }
    private void getUI(View view){
        text = (AutoResizeTextView) view.findViewById(R.id.text);
        goFact = (Button) view.findViewById(R.id.go_numberfact);
        goYear = (Button) view.findViewById(R.id.go_yearfact);
        goMath = (Button) view.findViewById(R.id.go_mathfact);
        goDate = (Button) view.findViewById(R.id.go_date);
        launchCalendar = (Button) view.findViewById(R.id.launch_calendar);
        editText = (EditText) view.findViewById(R.id.et_numberfact);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUI(view);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataHandler.getInstance().getNumberHandler().getTrivia(1 + (int) (Math.random() * 200), new ServiceListener<NumberFact>() {
                    @Override
                    public void onResponse(NumberFact response) {
                        if(response!=null){
                            text.setText(response.getText());
                        }
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
        });



        goFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().isEmpty()){
                    DataHandler.getInstance().getNumberHandler().getTrivia( new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {
                            if(response!=null){
                                text.setText(response.getText());
                                editText.setText("");
                            }
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                }else{

                    DataHandler.getInstance().getNumberHandler().getTrivia(Integer.valueOf(editText.getText().toString()), new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {
                            if(response!=null){
                                text.setText(response.getText());
                                editText.setText("");
                            }
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });

                }


            }
        });



        launchCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               java.util.Calendar newCalendar = java.util.Calendar.getInstance();
                DatePickerDialog fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        day = dayOfMonth;
                        month = monthOfYear;
                        editText.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear));
                    }

                }, newCalendar.get(java.util.Calendar.YEAR), newCalendar.get(java.util.Calendar.MONTH), newCalendar.get(java.util.Calendar.DAY_OF_MONTH));

            }
        });



        goDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(day==0 && month ==0){
                    DataHandler.getInstance().getNumberHandler().getDate(new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {

                            if(response!=null){
                                text.setText(response.getText());
                                day=0;
                                month=0;
                            }

                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                }else{

                    DataHandler.getInstance().getNumberHandler().getDate(day, month, new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {
                            if(response!=null){
                                text.setText(response.getText());
                                day=0;
                                month=0;
                                editText.setText("");
                            }
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                }





            }
        });


        goMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().isEmpty()){
                    DataHandler.getInstance().getNumberHandler().getMath( new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {
                            if(response!=null){
                                text.setText(response.getText());
                                editText.setText("");
                            }
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                }else{

                    DataHandler.getInstance().getNumberHandler().getMath(Integer.valueOf(editText.getText().toString()), new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {
                            if(response!=null){
                                text.setText(response.getText());
                                editText.setText("");
                            }
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });

                }


            }
        });

        goYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().isEmpty()){
                    DataHandler.getInstance().getNumberHandler().getYear( new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {
                            if(response!=null){
                                text.setText(response.getText());
                                editText.setText("");
                            }
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
                }else{

                    DataHandler.getInstance().getNumberHandler().getYear(Integer.valueOf(editText.getText().toString()), new ServiceListener<NumberFact>() {
                        @Override
                        public void onResponse(NumberFact response) {
                            if(response!=null){
                                text.setText(response.getText());
                                editText.setText("");
                            }
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });

                }

            }
        });



    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
