package com.example.dependencyinjectionstart.example2.di

import com.example.dependencyinjectionstart.example2.presentation.MainActivity
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    // Не можем использовать AppCompatActivity так как он не содержит @Inject
    fun inject(activity: MainActivity)

}