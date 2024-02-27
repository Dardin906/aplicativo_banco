package com.example.nubankavanado

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.nubankavanado.R


class Pix: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix2)
        setSupportActionBar(findViewById(R.id.toolbar4))
        val mensagem = intent.getStringExtra("Saldo")
        var textView = findViewById<TextView>(R.id.txtMensagem1).apply {
            text = mensagem
        }
        var saldo = mensagem
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnPix)
        btConf.setOnClickListener {
            val data = Intent()
            var valorpag = findViewById<EditText>(R.id.edtValor)
            var valorpagn = valorpag?.text.toString().toDouble()
                if (nsaldo < valorpagn) {
                    Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
                } else {
                    nsaldo -= valorpagn
                    var txtSaldo = nsaldo.toString()
                    textView.setText(txtSaldo)
                    data.putExtra("sSaldo", txtSaldo)
                    setResult(Activity.RESULT_OK, data)
                    Toast.makeText(this, "$txtSaldo", Toast.LENGTH_SHORT).show()
                    valorpag.setText("".toString())
                    finish()
                }

        }
    }
}
