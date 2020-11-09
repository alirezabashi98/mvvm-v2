package com.arb.mvvm_v2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arb.mvvm_v2.R
import com.arb.mvvm_v2.databinding.ActivityMainBinding
import com.arb.mvvm_v2.viewModel.ViewModelMainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recycler: RecyclerView
    lateinit var adapterTest : AdapterItemRecycler
    private val vm: ViewModelMainActivity by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.vm = vm

        adapterTest = AdapterItemRecycler(listOf())

        recycler = findViewById(R.id.recyclerView_main)
        recycler.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterTest
        }

        vm.array.observe(this, Observer {
            if (it != null)
            adapterTest.reloadData(it)
        })
    }
}