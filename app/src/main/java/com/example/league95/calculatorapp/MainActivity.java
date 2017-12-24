package com.example.league95.calculatorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
  private EditText editPercent, editNumber;
  private Button calculateButton;
  private TextView resultTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    editPercent = findViewById(R.id.percentEditText);
    editNumber = findViewById(R.id.numberEditText);
    calculateButton = findViewById(R.id.button);
    resultTextView = findViewById(R.id.resultTextView);

    calculateButton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        try
        {
          String num = editNumber.getText().toString();
          String per = editPercent.getText().toString();
          Double res = (Double.parseDouble(per) / 100) * Double.parseDouble(num);
          String finalResult = String.valueOf(res);
          resultTextView.setText(finalResult + " is " + Double.parseDouble(per) +"% of "+ Double.parseDouble(num));
        } catch (Exception e)
        {
          Log.i("Error ", e.getMessage());
          resultTextView.setText("Please Enter a Valid Number!");
        }
      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings)
    {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
