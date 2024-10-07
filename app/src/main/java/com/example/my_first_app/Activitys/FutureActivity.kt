package com.example.my_first_app.Activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_first_app.Adapters.FutureAdapters
import com.example.my_first_app.Domains.FutureDomain
import com.example.my_first_app.R
import java.nio.file.Paths

data class FutureDomain(val day: String, val picPath: String, val highTemp: Int, val lowTemp: Int)


class FutureActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FutureAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_future)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()
        setVariable();
    }

    private fun setVariable() {
        val backBtn: ConstraintLayout = findViewById(R.id.backBtn)
        backBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)) // Cambié el método para crear el Intent
        }
    }

    private fun initRecyclerView() {
        val items = ArrayList<FutureDomain>()

        items.add(FutureDomain("Sat", "storm", "Storm", 25, 10))
        items.add(FutureDomain("Sun", "cloudy", "Cloudy", 24, 16))
        items.add(FutureDomain("Mon", "windy", "Windy", 29, 15))
        items.add(FutureDomain("Tue", "cloudy_sunny", "Cloudy Sunny", 22, 13))
        items.add(FutureDomain("Wed", "sunny", "Sunny", 28, 11))
        items.add(FutureDomain("Thu", "rainy", "Rainy", 23, 12))

        recyclerView = findViewById(R.id.view2)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = FutureAdapters(items)
        recyclerView.adapter = adapter
    }
}
