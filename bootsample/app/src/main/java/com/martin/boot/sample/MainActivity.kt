package com.martin.boot.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.martin.boot.executeOnce

class MainActivity : AppCompatActivity() {

	private var textView: TextView? = null

	fun launchAllOperationsActivity(view: View) {
		val intent = Intent(this, OperationsActivity::class.java)
		startActivity(intent)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		textView = findViewById(R.id.main_text)

		executeOnce("main_text") {
			textView?.text = getString(R.string.first_time)
		}.alreadyExecuted {
			textView?.text = getString(R.string.not_first_time)
		}

		executeOnce("secondary_operation") {
			//do nothing
		}
	}
}