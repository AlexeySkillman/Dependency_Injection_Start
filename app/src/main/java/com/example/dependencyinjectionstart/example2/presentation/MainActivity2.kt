package com.example.dependencyinjectionstart.example2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjectionstart.R
import com.example.dependencyinjectionstart.example2.ExampleApp
import com.example.dependencyinjectionstart.example2.data.database.ExampleDatabase
import com.example.dependencyinjectionstart.example2.di.DaggerApplicationComponent
import com.example.dependencyinjectionstart.example2.di.ViewModelFactory
import javax.inject.Inject

class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ExampleViewModel::class.java]
    }
    private val viewModel2 by lazy {
        ViewModelProvider(this, viewModelFactory)[ExampleViewModel2::class.java]
    }

    // private val component = DaggerApplicationComponent.create()

    // builder
    //    private val component by lazy {
    //        DaggerApplicationComponent.builder()
    //            .context(application)
    //            .timeMillis(System.currentTimeMillis())
    //            .build()
    //    }

    // factory
    private val component by lazy {
        (application as ExampleApp).component
            .activityComponentFactory()
            .create("My_ID", "My_NAME")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject2(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.method()
        viewModel2.method()
    }

}