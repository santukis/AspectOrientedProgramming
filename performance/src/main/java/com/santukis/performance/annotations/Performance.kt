package com.santukis.performance.annotations

import com.santukis.performance.classes.PerformanceAction
import com.santukis.performance.classes.PerformanceExecution
import com.santukis.performance.classes.TraceType
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
annotation class Performance(
    val brand: String = "all",
    val execution: PerformanceExecution,
    val traceType: KClass<out TraceType>,
    val action: PerformanceAction
)