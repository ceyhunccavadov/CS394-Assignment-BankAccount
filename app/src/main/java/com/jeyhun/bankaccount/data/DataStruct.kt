package com.jeyhun.bankaccount.data

import android.content.Context
import com.jeyhun.bankaccount.R
import com.jeyhun.bankaccount.model.BankAcc

class DataStruct(val context: Context) {

    fun getFirstNames(): Array<String> = context.resources.getStringArray(R.array.first_names)
    fun getLastNames(): Array<String> = context.resources.getStringArray(R.array.last_names)
    fun getCardNumbers(): Array<String> = context.resources.getStringArray(R.array.card_number)
    fun getExpirationDates(): Array<String> = context.resources.getStringArray(R.array.expiration_dates)
    fun getCardTypes(): Array<String> = context.resources.getStringArray(R.array.card_type)
    fun getAccountBalances(): Array<String> = context.resources.getStringArray(R.array.account_balance)

    fun loadBankAccounts(): List<BankAcc> {
        val firstNames = getFirstNames()
        val lastNames = getLastNames()
        val cardNumbers = getCardNumbers()
        val expirationDates = getExpirationDates()
        val cardTypes = getCardTypes()
        val accountBalances = getAccountBalances()

        return List(firstNames.size) { i ->
            BankAcc(
                firstName = firstNames[i],
                lastName = lastNames[i],
                cardNumber = cardNumbers[i],
                expirationDate = expirationDates[i],
                cardType = cardTypes[i],
                accountBalance = accountBalances[i]
            )
        }
    }
}
