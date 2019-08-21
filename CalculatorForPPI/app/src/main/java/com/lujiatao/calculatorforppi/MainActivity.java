package com.lujiatao.calculatorforppi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText("PPI\nPixels Per Inch");
    }

    public void calculate(View view) {
        boolean isCalculator = true;
        int width = 0;
        int height = 0;
        double size = 0;
        long result = 0;
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        try {
            width = Integer.valueOf(editText1.getText().toString());
            if (width <= 0) {
                showAlert("宽");
                isCalculator = false;
            }
        } catch (NumberFormatException exception) {
            showAlert("宽");
            isCalculator = false;
        }
        if (isCalculator) {
            try {
                height = Integer.valueOf(editText2.getText().toString());
                if (height <= 0) {
                    showAlert("高");
                    isCalculator = false;
                }
            } catch (NumberFormatException exception) {
                showAlert("高");
                isCalculator = false;
            }
        }
        if (isCalculator) {
            try {
                size = Float.valueOf(editText3.getText().toString());
                if (size <= 0) {
                    showAlert("尺寸");
                    isCalculator = false;
                }
            } catch (NumberFormatException exception) {
                showAlert("尺寸");
                isCalculator = false;
            }
        }
        if (isCalculator) {
            result = Math.round(Math.pow((Math.pow(width, 2) + Math.pow(height, 2)) / Math.pow(size, 2), 0.5));
            textView.setText(result + " ppi");
        } else {
            textView.setText("PPI\nPixels Per Inch");
        }
    }

    private void showAlert(String string) {
        Toast.makeText(this, "请输入正确的屏幕" + string + "！", Toast.LENGTH_SHORT).show();
    }

}
