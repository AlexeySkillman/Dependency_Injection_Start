package com.example.dependencyinjectionstart.example2.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionstart.example2.di.annotations.IdQualifier
import com.example.dependencyinjectionstart.example2.di.annotations.NameQualifier
import com.example.dependencyinjectionstart.example2.domain.ExampleUseCase
import javax.inject.Inject
import javax.inject.Named

class ExampleViewModel @Inject constructor(
    private val useCase: ExampleUseCase,
    @IdQualifier private val id: String,
    @NameQualifier private val name: String
): ViewModel() {

    fun method() {
        useCase()
        Log.d("ExampleViewModel", "$id $name ExampleViewModel $this")
    }
}
