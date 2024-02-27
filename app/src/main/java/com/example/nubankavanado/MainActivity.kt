package com.example.nubankavanado

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.nubankavanado.Pix

class MainActivity : AppCompatActivity() {
    val COD_TELA = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnPix_click(view: View) {
        val txtSaldo = findViewById<EditText>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, Pix::class.java).apply {
            putExtra("Saldo", saldo)
        }
//         startActivity(intent)

        startActivityForResult(intent, COD_TELA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == COD_TELA && resultCode == Activity.RESULT_OK) {
            val txtsaldo = findViewById<TextView>(R.id.txtSaldo)
            val sSaldo = data!!.getStringExtra("sSaldo")
            txtsaldo.setText(sSaldo)
        }
    }

    fun btnPagar_click(view: View) {
        val txtsaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtsaldo.text.toString()
        val intent = Intent(this, PagarActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    fun btnTransf_click(view: View) {
        val txtsaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtsaldo.text.toString()
        val intent = Intent(this, TransfActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    fun btnDepos_click(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, DeposActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }
}