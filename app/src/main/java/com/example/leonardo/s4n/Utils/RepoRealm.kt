package com.example.leonardo.s4n.Utils

import com.example.leonardo.s4n.Entity.Info
import com.example.leonardo.s4n.Entity.InfoDao
import io.realm.Realm

open class RepoRealm {

    open fun saveInfo(info: Info):Int {
        val realm = Realm.getDefaultInstance()
        val currentId:Int
        val id=realm.where(InfoDao::class.java).max("id")
        if(id == null) {
            currentId = 1
        }else{
            currentId=(id as Long).inc().toInt()
        }
        realm.executeTransactionAsync {
            val info = InfoDao(
                currentId,
                info.headache,
                info.age,
                info.gender,
                info.alcohol,
                info.percent
            )
            it.copyToRealmOrUpdate(info)

        }
        return currentId
    }
}

