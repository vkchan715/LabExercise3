package com.example.labexercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculate()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset()
        }
    }
    private fun calculate(){
        val age = findViewById<Spinner>(R.id.spinnerAge).selectedItem.toString()
        val gender = radioGroupGender.checkedRadioButtonId
        val smoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        val male = resources.getResourceEntryName(gender)
        var premium: Int = 0
      if(age == "Less than 17"){
            premium = 60
      }else if(age == "17 to 25"){
          premium = 70
          if(male == "radioButtonMale" && smoker.isChecked) {
              premium += 50 + 100
            }
          else if(male != "radioButtonMale" && smoker.isChecked){
                premium += 100
            }
          else if(male == "radioButtonMale"){
                premium += 50
            }
      }else if(age == "26 to 30"){
          premium = 90
          if(male == "radioButtonMale" && smoker.isChecked) {
              premium += 150 + 100
          }
          else if(male != "radioButtonMale" && smoker.isChecked){
              premium += 150
          }
          else if(male == "radioButtonMale"){
              premium += 100
          }
      }else if(age == "31 to 40"){
          premium = 120
          if(male == "radioButtonMale" && smoker.isChecked) {
              premium += 150 + 200
          }
          else if(male != "radioButtonMale" && smoker.isChecked){
              premium += 200
          }
          else if(male == "radioButtonMale"){
              premium += 150
          }
      }else if(age == "41 to 55"){
          premium = 150
          if(male == "radioButtonMale" && smoker.isChecked) {
              premium += 200 + 250
          }
          else if(male != "radioButtonMale" && smoker.isChecked){
              premium += 250
          }
          else if(male == "radioButtonMale"){
              premium += 200
          }
      }else if(age == "More than 55"){
          premium = 150
          if(male == "radioButtonMale" && smoker.isChecked) {
              premium += 200 + 300
          }
          else if(male != "radioButtonMale" && smoker.isChecked){
              premium += 300
          }
          else if(male == "radioButtonMale"){
              premium += 200
          }
      }
        findViewById<TextView>(R.id.textViewPremium).setText("Insurance Premium : " + premium.toString())
    }

    private fun reset(){
        findViewById<Spinner>(R.id.spinnerAge).setSelection(0)
        findViewById<RadioGroup>(R.id.radioGroupGender).clearCheck()
        findViewById<CheckBox>(R.id.checkBoxSmoker).setChecked(false)
        findViewById<TextView>(R.id.textViewPremium).setText("Insurance Premium : ")
    }

}
