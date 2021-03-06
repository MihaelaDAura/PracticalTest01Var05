package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button top_left_button, top_right_button, bottom_left_button, bottom_right_button, center_button;
    private TextView all_terms_text;
    private Button navigate_to_secondary_activity_button;
    int val  = 0;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override

        public void onClick(View view) {
            String veche_val = all_terms_text.getText().toString();

            if(view.getId() == R.id.top_left_button) {
                if (veche_val != "") {
                    all_terms_text.setText(veche_val + ',' + "TOP LEFT");
                } else {
                    all_terms_text.setText("TOP LEFT");
                }
                val++;
            } else if(view.getId() == R.id.top_right_button) {
                if (veche_val != "") {
                    all_terms_text.setText(veche_val + ',' + "TOP RIGHT");
                } else {
                    all_terms_text.setText("TOP RIGHT");
                }
                val++;
            }  else if (view.getId() == R.id.bottom_left_button) {
                if (veche_val != "") {
                    all_terms_text.setText(veche_val + ',' + "BOTTOM LEFT");
                } else {
                    all_terms_text.setText("BOTTOM LEFT");
                }
                val++;
            } else if (view.getId() == R.id.bottom_right_button) {
                if (veche_val != "") {
                    all_terms_text.setText(veche_val + ',' + "BOTTOM RIGHT");
                } else {
                    all_terms_text.setText("BOTTOM RIGHT");
                }
                val++;
            } else if (view.getId() == R.id.center_button) {
                if (veche_val != "") {
                    all_terms_text.setText(veche_val + ',' + "CENTER");
                } else {
                    all_terms_text.setText("CENTER");
                }
                val++;
            } else if (view.getId() == R.id.navigate_to_secondary_activity_button) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                intent.putExtra("servetel3", veche_val);
                startActivityForResult(intent, 1);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_left_button = findViewById(R.id.top_left_button);
        top_right_button = findViewById(R.id.top_right_button);
        bottom_left_button = findViewById(R.id.bottom_left_button);
        bottom_right_button = findViewById(R.id.bottom_right_button);
        center_button = findViewById(R.id.center_button);

        all_terms_text = findViewById(R.id.all_terms_text);


        top_left_button.setOnClickListener(buttonClickListener);
        top_right_button.setOnClickListener(buttonClickListener);
        bottom_left_button.setOnClickListener(buttonClickListener);
        bottom_right_button.setOnClickListener(buttonClickListener);
        center_button.setOnClickListener(buttonClickListener);

        navigate_to_secondary_activity_button = findViewById(R.id.navigate_to_secondary_activity_button);
        navigate_to_secondary_activity_button.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("servetel2", val);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("servetel2")) {
            val = savedInstanceState.getInt("servetel2", 1);
            Toast.makeText(getApplicationContext(), "Valoare este " + val, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        val = 0;
        all_terms_text.setText("");
    }
}