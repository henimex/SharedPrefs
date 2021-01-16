package com.hendev.sharedpref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("basitVeri", Context.MODE_PRIVATE)
    }

    fun save(view: View) {
        id = txtName1.text.toString()

        if (id.isNullOrEmpty()) {
            Toast.makeText(this, "Please Input Your Username", Toast.LENGTH_LONG).show()
        } else {
            sharedPreferences.edit().putString("name", id).apply()
            Toast.makeText(this, "$id is Saved", Toast.LENGTH_SHORT).show()
        }
    }

    fun delete(view: View) {
        val getId = sharedPreferences.getString("name",null)
        val typedId = txtName1.text.toString()

        if ( getId == typedId){
            Toast.makeText(this, "Name SP $getId Deleted", Toast.LENGTH_LONG).show()
            sharedPreferences.edit().remove("name").apply()
        }else{
            Toast.makeText(this, "Couldnt Found $typedId in Shared", Toast.LENGTH_LONG).show()
        }

    }

    fun read(view: View) {
        txtView1.text = sharedPreferences.getString("name", "There is no Record")
    }
}