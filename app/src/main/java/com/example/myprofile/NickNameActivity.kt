package com.example.myprofile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nick_name.*

class NickNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_name)

        val nowNick = intent.getStringExtra("nowNick")
        nickNameEdt.setText(nowNick)

        goBackBtn.setOnClickListener {

            val msg = nickNameEdt.text.toString()
            val goBackIntent = Intent()
            goBackIntent.putExtra("message",msg)
            setResult(Activity.RESULT_OK,goBackIntent)

            finish()
        }
    }
}
