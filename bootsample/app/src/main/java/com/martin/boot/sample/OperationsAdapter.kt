package com.martin.boot.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.martin.boot.Operation

class OperationsAdapter(private val operations: List<Operation>) :
	RecyclerView.Adapter<OperationsAdapter.OperationsViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationsViewHolder {
		val inflater = LayoutInflater.from(parent.context)
		val view = inflater.inflate(R.layout.item_operation, parent, false)
		return OperationsViewHolder(view)
	}

	override fun onBindViewHolder(holder: OperationsViewHolder, position: Int) {
		holder.mark.text = "Mark: ${operations[position].mark}"
		holder.executed.text = "Executed: ${operations[position].executed}"
	}

	override fun getItemCount(): Int = operations.size

	inner class OperationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val mark: TextView = itemView.findViewById(R.id.mark)
		val executed: TextView = itemView.findViewById(R.id.executed)
	}

}