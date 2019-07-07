package com.example.activityforkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            // Intent
            intent.putExtra("x", "intent")

            // Bundle
            val bundle = Bundle()
            bundle.putString("y", "bundle")
            intent.putExtra("mBundle", bundle)

            // Parcelable
            val model = ModelParcelable()
            model.name = "Sarah"
            model.age = 27
            model.isMarred = true
            intent.putExtra("mParcelable", model)

            startActivity(intent)
        }


    }
}
