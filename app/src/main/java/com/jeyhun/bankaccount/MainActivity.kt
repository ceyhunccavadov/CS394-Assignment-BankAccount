package com.jeyhun.bankaccount

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.jeyhun.bankaccount.adapter.BankAdapter
import com.jeyhun.bankaccount.data.DataStruct

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val accounts = DataStruct(this).loadBankAccounts()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = BankAdapter(accounts)
        recyclerView.setHasFixedSize(true)
    }
}
