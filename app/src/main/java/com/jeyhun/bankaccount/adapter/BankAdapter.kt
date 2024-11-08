package com.jeyhun.bankaccount.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jeyhun.bankaccount.R
import com.jeyhun.bankaccount.UserDetailActivity
import com.jeyhun.bankaccount.model.BankAcc

class BankAdapter(private val data: List<BankAcc>): RecyclerView.Adapter<BankAdapter.BankViewHolder>() {
    inner class BankViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nameView: TextView = view.findViewById(R.id.nameTextView)
        private val profileView: TextView = view.findViewById(R.id.profileDescriptionTextView)

        fun bind(bankAccount: BankAcc) {
            nameView.text = "${bankAccount.firstName} ${bankAccount.lastName}"
            profileView.text = "Card: ${bankAccount.cardType} - Balance: ${bankAccount.accountBalance}"

            view.setOnClickListener {
                val context = itemView.context
                val showUserIntent = Intent(context, UserDetailActivity::class.java).apply {
                    putExtra(UserDetailActivity.BANK_ACCOUNT_DATA, bankAccount)
                }
                context.startActivity(showUserIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return BankViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
