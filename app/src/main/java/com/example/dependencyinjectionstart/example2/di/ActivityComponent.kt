package com.example.dependencyinjectionstart.example2.di

import com.example.dependencyinjectionstart.example2.di.annotations.IdQualifier
import com.example.dependencyinjectionstart.example2.di.annotations.NameQualifier
import com.example.dependencyinjectionstart.example2.presentation.MainActivity
import com.example.dependencyinjectionstart.example2.presentation.MainActivity2
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@Subcomponent(
    modules = [ViewModelModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)

    fun inject2(activity: MainActivity2)

    @Subcomponent.Factory
    interface  Factory{
        fun create( // @BindsInstance он не поимени собирает а по типу ииз-за этого ббудут ошибки
            @BindsInstance @IdQualifier id: String,
            @BindsInstance @NameQualifier name: String
        ):ActivityComponent
    }

}