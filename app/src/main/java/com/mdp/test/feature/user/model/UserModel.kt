package com.mdp.test.feature.user.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressModel
) : Parcelable

@Parcelize
data class AddressModel(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String
) : Parcelable
