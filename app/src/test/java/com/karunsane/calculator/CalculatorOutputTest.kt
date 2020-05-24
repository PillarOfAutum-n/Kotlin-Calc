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
        fun onePlusOne(){
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

    }