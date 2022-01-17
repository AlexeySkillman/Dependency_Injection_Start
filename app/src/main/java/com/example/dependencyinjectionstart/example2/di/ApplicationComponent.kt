package com.example.dependencyinjectionstart.example2.di

import android.content.Context
import com.example.dependencyinjectionstart.example2.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    // Не можем использовать AppCompatActivity так как он не содержит @Inject
    fun inject(activity: MainActivity)


// В новых версиях появилось возможность использовать Factory вместо Builder
//    @Component.Builder
//    interface ApplicationComponentBuilder{
//
//        @BindsInstance // Закидываем в граф зависимостей
//        fun context(context: Context): ApplicationComponentBuilder
//
//        @BindsInstance // Закидываем в граф зависимостей
//        fun  timeMillis(timeMillis: Long): ApplicationComponentBuilder
//
//        fun build(): ApplicationComponent
//
//    }


    // В новых версиях появилось возможность использовать Factory вместо Builder
    @Component.Factory
    interface ApplicationComponentFactory{
        fun create(
            @BindsInstance context: Context,
            @BindsInstance timeMillis: Long,
        ): ApplicationComponent
    }

}