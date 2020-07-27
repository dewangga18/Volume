package www.smktelkom.sch.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth,edtHeight,edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight= findViewById(R.id.edt_height);
        edtLength= findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_calculate){
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            boolean isinvalidDouble = false;
            if(TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edtLength.setError("Fields ini tidak boleh kososng");
            }
            if(TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                edtWidth.setError("Fields ini tidak boleh kososng");
            }
            if(TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeight.setError("Fields ini tidak boleh kososng");
            }
            Double length = toDouble(inputLength);
            Double width = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (length == null){
                isinvalidDouble=true;
                edtLength.setError("Field ini harus berupa nomer yang valid");
            }
            if (width == null){
                isinvalidDouble=true;
                edtWidth.setError("Field ini harus berupa nomer yang valid");
            }
            if (height == null){
                isinvalidDouble=true;
                edtHeight.setError("Field ini harus berupa nomer yang valid");
            }
            if (!isEmptyFields&&!isinvalidDouble){
                double volume = length * width *height;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}