package com.mdp.test.data.remote.user

import com.mdp.test.domain.model.Address
import com.mdp.test.domain.model.User

fun UserRemote.toUser(): User {
    return User(
        id = id ?: 0,
        name = name ?: "",
        username = username ?: "",
        email = email ?: "",
        address = address.toAddress()
    )
}

fun AddressRemote.toAddress(): Address {
    return Address(
        street = street ?: "",
        suite = suite ?: "",
        city = city ?: "",
        zipcode = zipcode ?: ""
    )
}