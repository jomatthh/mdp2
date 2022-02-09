package com.mdp.test.data.remote.user

data class UserRemote(
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?,
    val address: AddressRemote
)

data class AddressRemote(
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipcode: String?
)