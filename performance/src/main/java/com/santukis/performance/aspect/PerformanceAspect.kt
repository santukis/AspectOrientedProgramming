package com.santukis.performance.aspect

import android.util.Log
import com.santukis.performance.annotations.Performance
import com.santukis.performance.classes.PerformanceExecution
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.aspectj.lang.reflect.MethodSignature

@Aspect
class PerformanceAspect {

    @Around("execution(@com.santukis.performance.annotations.Performance * *(..))")
    fun registerPerformance(joinPoint: ProceedingJoinPoint): Any? {
        val methodSignature = joinPoint.signature as MethodSignature
        val methodName = methodSignature.name
        var result: Any? = null

        methodSignature.method.getAnnotation(Performance::class.java)?.let { annotation ->
            when (annotation.execution) {
                PerformanceExecution.BEFORE -> {
                    Log.d("Performance", "Before $methodName execution, brand: ${annotation.brand}, action: ${annotation.action.name}, traceType: ${annotation.traceType::class.simpleName}")
                    result = joinPoint.proceed(joinPoint.args)
                }
                PerformanceExecution.AFTER -> {
                    result = joinPoint.proceed(joinPoint.args)
                    Log.d("Performance", "After $methodName execution, brand: ${annotation.brand}, action: ${annotation.action.name}, traceType: ${annotation.traceType::class.simpleName}")
                }
            }
        }

        return result
    }
}