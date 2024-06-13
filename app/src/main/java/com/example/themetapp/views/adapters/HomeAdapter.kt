package com.example.themetapp.views.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.themetapp.R
import com.example.themetapp.models.DepartmentModel
import com.example.themetapp.views.DepartmentPage


class HomeAdapter(
    private val context: Context,
    private val departments: List<DepartmentModel>
) :
    RecyclerView.Adapter<HomeAdapter.DepartmentItem>() {

    class DepartmentItem(view: View) : RecyclerView.ViewHolder(view) {
        val departmentCard: CardView = view.findViewById(R.id.department_item)
        val departmentText: TextView = view.findViewById(R.id.department_item_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentItem {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.department_item, parent, false)


        return DepartmentItem(view)
    }

    override fun onBindViewHolder(holder: DepartmentItem, position: Int) {
        val department = departments[position]
        holder.departmentText.text = department.displayName
        holder.departmentCard.setOnClickListener {
            val intent = Intent(
                context,
                DepartmentPage::class.java
            ).apply {
                putExtra("departmentModel", department)
            }
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return departments.size
    }
}