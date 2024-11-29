
package com.example.gstcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gstcalculator.R;

public class MainActivity extends Activity {

    private EditText etProductName, etQuantity, etPrice;
    private Button btnCalculate;
    private TextView tvTotalAmount, tvGSTAmount, tvNetAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etProductName = findViewById(R.id.et_product_name);
        etQuantity = findViewById(R.id.et_quantity);
        etPrice = findViewById(R.id.et_price);

        btnCalculate = findViewById(R.id.btn_calculate);

        tvTotalAmount = findViewById(R.id.tv_total_amount);
        tvGSTAmount = findViewById(R.id.tv_gst_amount);
        tvNetAmount = findViewById(R.id.tv_net_amount);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBill();
            }
        });
    }

    private void calculateBill() {
        String productName = etProductName.getText().toString().trim();
        int quantity = Integer.parseInt(etQuantity.getText().toString().trim());
        double price = Double.parseDouble(etPrice.getText().toString().trim());

        double totalAmount = quantity * price;
        double gstAmount = totalAmount * 0.18;
        double netAmount = totalAmount + gstAmount;

        tvTotalAmount.setText(String.format("Total Amount: ₹%.2f", totalAmount));
        tvGSTAmount.setText(String.format("GST Amount: ₹%.2f", gstAmount));
        tvNetAmount.setText(String.format("Net Amount: ₹%.2f", netAmount));
    }
}
