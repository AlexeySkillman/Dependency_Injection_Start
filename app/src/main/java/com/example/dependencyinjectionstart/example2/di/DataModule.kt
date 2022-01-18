package com.example.dependencyinjectionstart.example2.di

import com.example.dependencyinjectionstart.example2.data.datasource.*
import com.example.dependencyinjectionstart.example2.di.annotations.ApplicationScopeSingletons
import com.example.dependencyinjectionstart.example2.di.annotations.ProdQualifier
import com.example.dependencyinjectionstart.example2.di.annotations.TestQualifier
import dagger.Binds
import dagger.Module

@Module
interface DataModule{

    @ApplicationScopeSingletons
    @Binds
    fun bindExampleLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource

    @ProdQualifier
    @ApplicationScopeSingletons
    @Binds
    fun bindRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource

    @TestQualifier
    @ApplicationScopeSingletons
    @Binds
    fun bindTestRemoteDataSource(impl: TestRemoteDataSourceImpl): ExampleRemoteDataSource

}