package com.example.activityforkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    var text = "blank"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Intent
        val x = intent.getStringExtra("x")

        // Bundle
        var y = ""
        val bundle = intent.getBundleExtra("mBundle")
        if (bundle != null) {
            y = bundle.getString("y", "")
        }

        // Parcelable
        var z = ModelParcelable()
        val parcelable = intent.getParcelableExtra<ModelParcelable>("mParcelable")
        if (parcelable != null) {
            z = parcelable
        }

        // SetView
        tv_1.text = x
        tv_2.text = y
        tv_3.text = z.name + ":" + z.age + ":" + z.isMarred

        // Test Instance State
        btn_0.setOnClickListener {
            text = et_1.text.toString()
        }
        btn_1.setOnClickListener {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        text = savedInstanceState.getString("text", "default")
    }
}
