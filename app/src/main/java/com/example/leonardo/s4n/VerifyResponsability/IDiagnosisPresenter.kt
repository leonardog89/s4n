package com.example.leonardo.s4n.VerifyResponsability

import com.example.leonardo.s4n.Entity.Info

interface IDiagnosisPresenter {
    fun verify(info: Info)
}
interface IDiagnosisListener {
    fun onVerifySuccess(info: Info)
}