package com.example.daftarmahasiswa

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarmahasiswa.model.AppDatabase
import com.example.daftarmahasiswa.model.Student
import com.example.daftarmahasiswa.model.StudentAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var studentAdapter: StudentAdapter
    // ... deklarasi variabel view binding/findViewById ...

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama: EditText = findViewById(R.id.etNama)
        val etNim: EditText = findViewById(R.id.etNim)
        val  btnSave: Button = findViewById(R.id.btnSave)
        val rvStudent: RecyclerView = findViewById(R.id.rvStudent)

        // 1. Inisialisasi Database
        db = AppDatabase.getDatabase(this)

        // 2. Setup RecyclerView & Adapter
        studentAdapter = StudentAdapter(arrayListOf())
        // ... set adapter ke recyclerview ...

        rvStudent.adapter = studentAdapter
        rvStudent.layoutManager = LinearLayoutManager(this)

        // 3. Load Data Awal
        loadData()

        // 4. Aksi Tombol Simpan
        btnSave.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = etNim.text.toString()

            val newStudent = Student(nama = nama, nim = nim)

            // Simpan ke DB menggunakan Coroutine (Background Thread)
            lifecycleScope.launch {
                db.studentDao().insertStudent(newStudent)
                loadData() // Refresh list setelah simpan
                etNama.text.clear()
                etNim.text.clear()
            }
        }
    }

    private fun loadData() {
        lifecycleScope.launch {
            val students = db.studentDao().getAllStudents()
            studentAdapter.setData(students) // Pastikan ada fungsi setData di Adapter
            studentAdapter.notifyDataSetChanged()
        }
    }
}
