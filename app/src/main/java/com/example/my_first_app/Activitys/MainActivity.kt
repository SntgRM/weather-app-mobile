package com.example.my_first_app.Activitys

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_first_app.Adapters.HourlyAdapters
import com.example.my_first_app.Domains.Hourly
import com.example.my_first_app.R

data class Hourly(val hour: String, val temp: Int, val picPath: String)

class MainActivity : AppCompatActivity() {
    private lateinit var adapterHourly: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView();
        setVariable();
    }

    private fun setVariable() {
        val next7daysBtn: TextView = findViewById(R.id.nextBtn)
        next7daysBtn.setOnClickListener {
            startActivity(Intent(this, FutureActivity::class.java))
        }
    }

    private fun initRecyclerView() {
        val items = ArrayList<Hourly>()

        items.add(Hourly("9 pm",  28,  "cloudy"))
        items.add(Hourly("11 pm",  29,  "sunny"))
        items.add(Hourly("12 pm",  30,  "wind"))
        items.add(Hourly("1 am",  29,  "rain"))
        items.add(Hourly("2 am",  27,  "storm"))

        recyclerView=findViewById(R.id.view1);
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapterHourly = HourlyAdapters(items)
        recyclerView.adapter = adapterHourly
    }

}

