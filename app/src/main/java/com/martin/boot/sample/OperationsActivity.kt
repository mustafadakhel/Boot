package com.martin.boot.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.martin.boot.Boot
import com.martin.sample.sample.R

class OperationsActivity : AppCompatActivity() {

    var recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operations)

        recycler = findViewById(R.id.operations_recycler)

        val operations = Boot.getAllOperations()
        val adapter = OperationsAdapter(operations)

        recycler?.adapter = adapter
    }
}

