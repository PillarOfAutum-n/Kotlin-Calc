package com.karunsane.calculator

import com.karunsane.calculator.calculator.CalculatorOutputInterfaceView
import com.karunsane.calculator.calculator.CalculatorOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class CalculatorOutputTest {
        private val mnPresenter = CalculatorOutputPresenter
        private val mnMockView = Mockito.mock(CalculatorOutputInterfaceView::class.java)

        @Test
        fun sum(){
            //Attached
            mnPresenter.attach(mnMockView)
            //When item added to the strimg
            mnPresenter.add("2")
            mnPresenter.add("+")
            mnPresenter.add("5")
            //Then
            then(mnMockView).should().setEquation("2+5")
            then(mnMockView).should().setOutcome("7")
        }

        @Test
        fun rest()
        {
            mnPresenter.attach(mnMockView)
            mnPresenter.add("2")
            mnPresenter.add("-")
            mnPresenter.add("5")
            then(mnMockView).should().setEquation("2-5")
            then(mnMockView).should().setOutcome("-3")
        }

        @Test
        fun divide()
        {
            mnPresenter.attach(mnMockView)
            mnPresenter.add("2")
            mnPresenter.add("/")
            mnPresenter.add("5")
            then(mnMockView).should().setEquation("2/5")
            //Library for calculation can't handle decimals.
            then(mnMockView).should().setOutcome("0")
        }

        @Test
        fun multiply()
        {
            mnPresenter.attach(mnMockView)
            mnPresenter.add("2")
            mnPresenter.add("*")
            mnPresenter.add("5")
            then(mnMockView).should().setEquation("2*5")
            then(mnMockView).should().setOutcome("10")
        }

    }