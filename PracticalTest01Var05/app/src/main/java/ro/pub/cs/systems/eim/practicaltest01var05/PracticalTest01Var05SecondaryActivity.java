package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {
    private TextView total_press_edit_text;
    private Button okButton, cancelButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_button:
                    setResult(1, null);
                    break;
                case R.id.cancel_button:
                    setResult(2, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        total_press_edit_text = findViewById(R.id.total_press_edit_text);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("servetel3")) {
            String all_text = intent.getStringExtra("servetel3");
            total_press_edit_text.setText(String.valueOf(all_text));
        }

        okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}