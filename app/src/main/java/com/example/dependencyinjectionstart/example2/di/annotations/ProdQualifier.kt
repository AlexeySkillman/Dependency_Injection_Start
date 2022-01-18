package com.example.dependencyinjectionstart.example2.di.annotations

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ProdQualifier()
