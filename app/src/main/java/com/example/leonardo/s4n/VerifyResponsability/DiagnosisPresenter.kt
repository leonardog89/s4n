package com.example.leonardo.s4n.VerifyResponsability

import com.example.leonardo.s4n.Entity.Info

class DiagnosisPresenter(val view: IDiagnosisView): IDiagnosisPresenter,
    IDiagnosisListener {

    private val bl: IDiagnosisBl =
        DiagnosisBl(listener = this)

    override fun verify(info: Info) {
        bl.verify(info = info)
    }

    override fun onVerifySuccess(info: Info) {
        view.showVerifyDone(info = info)
    }
}