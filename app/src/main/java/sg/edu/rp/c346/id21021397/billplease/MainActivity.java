package sg.edu.rp.c346.id21021397.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText Amt;
    EditText Pax;
    EditText Discount;
    ToggleButton Svs;
    ToggleButton Gst;
    Button Split;
    Button Reset;
    RadioGroup PaymentGroup;
    TextView Bill;
    TextView Each;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Amt = findViewById(R.id.editTextAmount);
        Pax = findViewById(R.id.editTextPax);
        Discount = findViewById(R.id.editTextPercentage);
        Svs = findViewById(R.id.btnSVS);
        Gst = findViewById(R.id.btnGST);
        Split = findViewById(R.id.btnSplit);
        Reset = findViewById(R.id.btnReset);
        PaymentGroup = findViewById(R.id.PaymentGroup);
        Bill = findViewById(R.id.TextBills);
        Each = findViewById(R.id.TextSplit);


        Split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Amount =Double.parseDouble(Amt.getText().toString());
                int Dis = Integer.parseInt(Discount.getText().toString())/100;
                int checkedRadioId = PaymentGroup.getCheckedRadioButtonId();
                if(checkedRadioId == R.id.RadioCash) {
                    if (Gst.isChecked() == true) {
                        if (Svs.isChecked() == true) {
                            double Total = Amount * (1 - Dis + 0.17);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f",cut));
                        } else {
                            double Total = Amount * (1 - Dis + 0.07);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f",cut));
                        }
                    } else {
                        if (Svs.isChecked() == true) {
                            double Total = Amount * (1 - Dis + 0.10);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f",cut));
                        } else {
                            double Total = Amount * (1 - Dis);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f",cut));
                        }
                    }
                }else {
                    if (Gst.isChecked() == true) {
                        if (Svs.isChecked() == true) {
                            double Total = Amount * (1 - Dis + 0.17);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f", cut) + " via PayNow to 912345678");
                        } else {
                            double Total = Amount * (1 - Dis + 0.07);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f", cut) + " via PayNow to 912345678");
                        }
                    } else {
                        if (Svs.isChecked() == true) {
                            double Total = Amount * (1 - Dis + 0.10);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f", cut) + " via PayNow to 912345678");
                        } else {
                            double Total = Amount * (1 - Dis);
                            double cut = Total / Integer.parseInt(Pax.getText().toString());
                            Bill.setText("Total: " + String.format("%.2f", Total));
                            Each.setText("Each Pays:" + String.format("%.2f", cut) + " via PayNow to 912345678");
                        }
                    }
                }




            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amt.setText("");
                Pax.setText("");
                Discount.setText("");
                Svs.setChecked(true);
                Gst.setChecked(true);
                PaymentGroup.clearCheck();
                Bill.setText("Total:");
                Each.setText("Each Pays: ");


            }
        });
    }
}