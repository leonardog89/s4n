package com.example.leonardo.s4n.Entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class InfoDao(
    @PrimaryKey open var id: Int? = null,
    open var headache: String?=null,
    open var age: String?=null,
    open var gender: String?=null,
    open var alcohol: String?=null,
    open var percent: String? = null
)
    : RealmObject() {
}