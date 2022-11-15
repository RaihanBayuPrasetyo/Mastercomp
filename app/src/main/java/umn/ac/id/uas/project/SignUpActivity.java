package umn.ac.id.uas.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView title1 = findViewById(R.id.title1);
        TextView title2 = findViewById(R.id.title2);

        TextPaint paint = title1.getPaint();
        float width = paint.measureText(title1.getText().toString());

        Shader textShader = new LinearGradient(0, 0, width, title1.getTextSize(),
                new int[]{
                        Color.parseColor("#CC2B5E"),
                        Color.parseColor("#753A88"),
                }, null, Shader.TileMode.CLAMP);
        title1.getPaint().setShader(textShader);

        paint = title2.getPaint();
        width = paint.measureText(title2.getText().toString());

        textShader = new LinearGradient(0, 0, width, title2.getTextSize(),
                new int[]{
                        Color.parseColor("#CC2B5E"),
                        Color.parseColor("#753A88"),
                }, null, Shader.TileMode.CLAMP);
        title2.getPaint().setShader(textShader);
    }
}