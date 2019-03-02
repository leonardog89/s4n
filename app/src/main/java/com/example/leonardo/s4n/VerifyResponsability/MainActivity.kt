package com.example.leonardo.s4n.VerifyResponsability

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.leonardo.s4n.Entity.Info
import com.example.leonardo.s4n.R
import kotlinx.android.synthetic.main.activity_main.*

class   MainActivity : AppCompatActivity(), IDiagnosisView {

    private val presenter: IDiagnosisPresenter =
        DiagnosisPresenter(view = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageAdapter = ArrayAdapter.createFromResource(this, R.array.yes_not_array,android.R.layout.simple_spinner_item)
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAge.adapter = ageAdapter

        val headacheAdapter = ArrayAdapter.createFromResource(this,
            R.array.yes_not_array,android.R.layout.simple_spinner_item)
        headacheAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerHeadache.adapter = headacheAdapter

        val genderAdapter = ArrayAdapter.createFromResource(this, R.array.gender_array,android.R.layout.simple_spinner_item)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = genderAdapter

        val alcoholAdapter = ArrayAdapter.createFromResource(this,
            R.array.yes_not_array,android.R.layout.simple_spinner_item)
        alcoholAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAlcohol.adapter = alcoholAdapter

        bt_Evaluator.setOnClickListener { onVerifyClick() }

    }

    private fun onVerifyClick(){
        val info = Info(
            headache = spinnerHeadache.selectedItem.toString(),
            age = spinnerAge.selectedItem.toString(),
            gender = spinnerGender.selectedItem.toString(),
            alcohol = spinnerAlcohol.selectedItem.toString()
        )
        presenter.verify(info = info)
    }

    override fun showVerifyDone(info: Info) {
        tv_result.text = getString(R.string.resultTxt)+" "+info.percent+"%"
    }

}
