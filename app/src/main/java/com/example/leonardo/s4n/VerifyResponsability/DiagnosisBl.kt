package com.example.leonardo.s4n.VerifyResponsability

import com.example.leonardo.s4n.Entity.Info
import com.example.leonardo.s4n.Utils.RepoRealm

class DiagnosisBl(val listener: IDiagnosisListener):
    IDiagnosisBl {

    override fun verify(info: Info) {
        var percent = 0
        if (("SÍ") == info.headache){
            percent += 25
        }
        if (("SÍ") == info.age){
            percent += 25
        }
        if (("FEMENINO") == info.gender){
            percent += 25
        }
        if (("SÍ") == info.alcohol){
            percent += 25
        }
        info.percent = ""+percent
        val repoRealm = RepoRealm()
        repoRealm.saveInfo(info=info)
        listener.onVerifySuccess(info = info)
    }
}