package com.example.myprofile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_MESSAGE_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            getNickBtn.setOnClickListener {

                var name = nickTxt.text.toString()
                if(name=="닉네임표시")
                {
                    name = ""
                }
                val myIntent = Intent(this, NickNameActivity::class.java)
                myIntent.putExtra("nowNick",name)
                startActivityForResult(myIntent,REQ_MESSAGE_CODE)
            }

        dialBtn.setOnClickListener {
            val phoneNum=phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)
        }
        smstoBtn.setOnClickListener {

            val phoneNum=phoneNumEdt.text.toString()
            val msg=messageEdt.text.toString()
            val myUri = Uri.parse("smsto:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body",msg)

            startActivity(myIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

          if(requestCode == REQ_MESSAGE_CODE)
          {
              if(resultCode == Activity.RESULT_OK)
              {
                  val msg = data?.getStringExtra("message")
                  nickTxt.text = msg

                  Toast.makeText(this,"닉네임변경완료", Toast.LENGTH_SHORT).show()
              }
          }
    }
}
