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
import com.example.themetapp.models.ObjectModel
import com.example.themetapp.views.ObjectPage

class DepartmentsAdapter(
    private val context: Context,
    private val objects: List<ObjectModel>
) :
    RecyclerView.Adapter<DepartmentsAdapter.DepartmentObject>() {

    class DepartmentObject(view: View) : RecyclerView.ViewHolder(view) {
        val departmentObjectCard: CardView = view.findViewById(R.id.department_object)
        val departmentObjectName: TextView = view.findViewById(R.id.department_object_name)
        val departmentObjectAuthor: TextView = view.findViewById(R.id.department_object_author)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentObject {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.department_object, parent, false)


        return DepartmentObject(view)
    }

    override fun onBindViewHolder(holder: DepartmentObject, position: Int) {
        val departmentObject = objects[position]

        holder.departmentObjectName.text = departmentObject.title
        holder.departmentObjectAuthor.text = departmentObject.artistDisplayName
        holder.departmentObjectCard.setOnClickListener {
            val intent = Intent(
                context,
                ObjectPage::class.java
            ).apply {
                putExtra("objectModel", departmentObject)
            }
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return objects.size
    }
}
