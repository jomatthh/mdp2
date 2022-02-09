package com.mdp.test.feature.user.mapper

import com.mdp.test.domain.model.Address
import com.mdp.test.domain.model.User
import com.mdp.test.feature.user.model.AddressModel
import com.mdp.test.feature.user.model.UserModel

fun User.toUserModel(): UserModel{
    return UserModel(
        id = id,
        name = name,
        username = username,
        email = email,
        address = address.toAddressModel()
    )
}

fun Address.toAddressModel(): AddressModel{
    return AddressModel(
        street = street,
        suite = suite,
        city = city,
        zipcode = zipcode
    )
}