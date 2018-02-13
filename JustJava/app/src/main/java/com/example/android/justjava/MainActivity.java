package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.text.NumberFormat;

import static android.R.attr.name;
import static android.R.id.edit;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText editText = (EditText)findViewById(R.id.username_view);
        String name = editText.getText().toString();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice(Boolean addWhippedCream, Boolean addChocolate) {
        int basePrice = 5;
        if (addChocolate)
            basePrice += 2;
        if (addWhippedCream)
            basePrice += 1;

        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price, Boolean addWhippedCream, Boolean addChocolate, String username){
        String orderSummary = getString(R.string.name, username) +
                              "\n" + getString(R.string.add_whipped_cream) + addWhippedCream +
                              "\n" + getString(R.string.add_chocolate) + addChocolate +
                              "\n" + getString(R.string.quantity) + quantity +
                              "\n" + getString(R.string.total, NumberFormat.getCurrencyInstance().format(price)) +
                              "\n" + getString(R.string.thank_you);
        return orderSummary;
    }

    public void increment(View view){
        if (quantity < 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
        else {
            Toast.makeText(this, "Maximum is 100", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void decrement(View view){
        if (quantity > 1) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
        else {
            Toast.makeText(this, "Minimum is 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


}