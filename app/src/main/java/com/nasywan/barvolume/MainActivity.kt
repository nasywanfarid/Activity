package com.nasywan.barvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var edtLength : EditText
    private lateinit var btnCalculate : Button
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult =findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()){
                isEmptyFields = true
                edtLength.error = "Failed ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyFields = true
                edtHeight.error ="Failed ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyFields = true
                edtWidth.error = "Failed ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }

    }
}