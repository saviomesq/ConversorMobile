package com.example.monetarioofc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById<TextView>(R.id.txt_result)

        val buttonConverter = findViewById<Button>(R.id.btn_converter)

        buttonConverter.setOnClickListener{
            converter()
        }
    }

    private fun converter() {
        val selectedCurrey = findViewById<RadioGroup>(R.id.radio_group)
        val checked = selectedCurrey.checkedRadioButtonId

        val editField = findViewById<EditText>(R.id.editTextNumber)
        val value = editField.text.toString()

        val currency = when(checked){
            R.id.radio_usd ->{
                "USD"
                result.text = "R$${"%.2f".format(value.toDouble()*4.91)}"
                result.visibility= View.VISIBLE
            }
            R.id.radio_eur -> {
                "EUR"
                result.text = "R$${"%.2f".format(value.toDouble()*5.25)}"
                result.visibility= View.VISIBLE
            }
            else -> {
                "CLP"
                result.text = "R$${"%.4f".format(value.toDouble()*0.0053)}"
                result.visibility= View.VISIBLE
            }
        }

        //val editField = findViewById<EditText>(R.id.editTextNumber)
        //val value = editField.text.toString()
        //if(value.isEmpty()) {
        //    return
        //}

    }
}
