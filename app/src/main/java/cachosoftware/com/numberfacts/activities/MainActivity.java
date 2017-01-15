package cachosoftware.com.numberfacts.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cachosoftware.com.numberfacts.R;
import cachosoftware.com.numberfacts.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, MainFragment.newInstance(), null).commit();
    }
}
