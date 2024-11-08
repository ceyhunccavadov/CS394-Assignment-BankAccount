package com.jeyhun.bankaccount.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BankAcc(
    val firstName: String = "",
    val lastName: String = "",
    val cardNumber: String = "",
    val expirationDate: String = "",
    val cardType: String = "",
    val accountBalance: String = ""
) : Parcelable

