package com.example.quizkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizkotlin.Adapter.CategoryAdapter
import com.example.quizkotlin.Common.SpaceItemDecoration
import com.example.quizkotlin.DBHelper.DBHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Saim Quiz 2020"
        setSupportActionBar(toolbar)
        recycler_category.setHasFixedSize(true)
        recycler_category.layoutManager = GridLayoutManager(this,2)

        val adapter = CategoryAdapter(this,DBHelper.getInstance(this).allCategories)
        recycler_category.addItemDecoration(SpaceItemDecoration(4))
        recycler_category.adapter = adapter
    }
}
