package com.karunsane.calculator.calculator

import android.view.View
import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresenter {
    private var mnView: CalculatorOutputInterfaceView? = null

    //local var
    //current equation
    private var mnCurrentEquation: String = ""

    // current outcome
    private var mnCurrentOutcome: String = ""

    //interpreter
    private val mnInterpreter = Interpreter()

    fun attach(view: CalculatorOutputInterfaceView) {
        mnView = view
    }

    fun dettach(){
        mnView = null
    }

    fun add(item: String){
        mnCurrentEquation = mnCurrentEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun solve(){
        if (mnCurrentOutcome.isNotEmpty()){
            mnCurrentEquation = mnCurrentOutcome
            mnCurrentOutcome = ""

        }else{}
        updateEquation()
        updateOutcome()
    }

    fun remove(){
        if(mnCurrentEquation.length > 1){
            mnCurrentEquation = mnCurrentEquation.substring(0, mnCurrentEquation.length - 1)
        }else{
            mnCurrentEquation = ""
        }
        calculateOutcome()
        updateEquation()
        updateOutcome()
    }

    fun clear(){
        mnCurrentEquation = ""
        mnCurrentOutcome = ""
        updateOutcome()
        updateEquation()
    }

    private fun calculateOutcome(){
        if(mnCurrentEquation.isNotEmpty()){
            try{
                mnInterpreter.eval("result = $mnCurrentEquation")
                val result = mnInterpreter.get("result")
                if (result != null && result is Int){
                    mnCurrentOutcome = result.toString()

                }
            }catch(e: Exception){
                mnCurrentOutcome = ""
            }
        }else{
            mnCurrentOutcome = ""
        }
    }

    private fun updateEquation(){
        mnView?.setEquation(mnCurrentEquation)
    }

    private fun updateOutcome() {
        mnView?.setOutcome(mnCurrentOutcome)
    }

}