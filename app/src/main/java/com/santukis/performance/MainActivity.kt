package com.santukis.performance.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.santukis.performance.annotations.Performance
import com.santukis.performance.classes.PerformanceAction
import com.santukis.performance.classes.PerformanceExecution
import com.santukis.performance.classes.TraceType

class MainActivity : AppCompatActivity() {

    @Performance(
        brand = "sampleBrand",
        execution = PerformanceExecution.BEFORE,
        traceType = TraceType.OnStart::class,
        action = PerformanceAction.START
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Performance", "During onCreate call")
        setContentView(R.layout.activity_main)
    }

    @Performance(
        brand = "sampleBrand",
        execution = PerformanceExecution.AFTER,
        traceType = TraceType.OnStart::class,
        action = PerformanceAction.STOP
    )
    override fun onResume() {
        super.onResume()
        Log.d("Performance", "During onResume call")
    }
}