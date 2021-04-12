package com.martin.boot.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.martin.boot.runOnce
import com.martin.sample.sample.R

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

		runOnce("main_text") {
			textView?.text = getString(com.martin.sample.sample.R.string.first_time)
		}.alreadyRun {
			textView?.text = getString(com.martin.sample.sample.R.string.not_first_time)
		}

		runOnce("secondary_operation") {
			//do nothing
		}
	}
}