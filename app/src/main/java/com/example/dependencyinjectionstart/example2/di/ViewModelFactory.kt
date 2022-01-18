package com.example.dependencyinjectionstart.example2.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjectionstart.example2.domain.ExampleRepository
import com.example.dependencyinjectionstart.example2.domain.ExampleUseCase
import com.example.dependencyinjectionstart.example2.presentation.ExampleViewModel
import com.example.dependencyinjectionstart.example2.presentation.ExampleViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModelsProviders: @JvmSuppressWildcards Map<Class<out ViewModel>,Provider<ViewModel>>
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelsProviders[modelClass]?.get() as T
    }
}

/*
class ViewModelFactory @Inject constructor(
    private val exampleUseCase: ExampleUseCase,
    private val repository: ExampleRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == ExampleViewModel::class.java){
            return ExampleViewModel(exampleUseCase) as T
        }
        if (modelClass == ExampleViewModel2::class.java){
            return ExampleViewModel2(repository) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}
*/
