package com.example.daftarmahasiswa.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarmahasiswa.R

class StudentAdapter(private val studentList:ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int
    ) {
        val student = studentList[position]
        holder.itemNama.text = student.nama
        holder.itemNim.text = student.nim
    }

    override fun getItemCount(): Int {
        return studentList.size
    }


    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemNama: TextView = view.findViewById(R.id.itemNama)
        val itemNim: TextView = view.findViewById(R.id.itemNim)
    }

    fun setData(students: List<Student>) {
        studentList.clear()
        studentList.addAll(students)
        notifyDataSetChanged()
    }
}