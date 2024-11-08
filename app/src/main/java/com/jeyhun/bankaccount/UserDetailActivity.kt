package com.jeyhun.bankaccount

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.jeyhun.bankaccount.databinding.ActivityUserDetailBinding
import com.jeyhun.bankaccount.model.BankAcc

class UserDetailActivity : AppCompatActivity() {
    companion object {
        const val BANK_ACCOUNT_DATA = "bank_account_data"
        private const val TAG = "UserDetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        try {
            val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

            val bankAccount: BankAcc = intent.getParcelableExtra(BANK_ACCOUNT_DATA) ?: BankAcc()
            Log.d(TAG, "Received bank account object: $bankAccount")

            binding.bankacc = bankAccount
        } catch (e: Exception) {
            Log.e(TAG, "Error in onCreate(): ", e)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
