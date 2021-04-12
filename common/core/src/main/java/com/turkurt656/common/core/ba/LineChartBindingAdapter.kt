package com.turkurt656.common.core.ba

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.turkurt656.library.designsystem.ktx.orBlack

object LineChartBindingAdapter {

    // Some values here are hardcoded but we can add more customization
    @BindingAdapter(
        "bind:data",
        "bind:dashedLine",
        "bind:lineColor",
        "bind:circleColor",
        "bind:fillDrawable",
        requireAll = false
    )
    @JvmStatic
    fun setData(
        lineChart: LineChart,
        data: Map<Float, Float>?,
        dashedLine: Boolean?,
        lineColor: Int?,
        circleColor: Int?,
        fillDrawable: Drawable?
    ) {

        if (data == null) return

        val entries = mutableListOf<Entry>()
        for ((i, v) in data) {
            entries.add(Entry(i, v))
        }

        val set = LineDataSet(entries, "").apply {
            if (dashedLine == true) // Default false
                enableDashedLine(10f, 5f, 0f)
            color = lineColor.orBlack()
            lineWidth = 1f

            setCircleColor(circleColor.orBlack())
            circleRadius = 3f
            setDrawCircleHole(false)

            setDrawFilled(true)
            setFillFormatter { _, _ ->
                lineChart.axisLeft.axisMinimum
            }
            this.fillDrawable = fillDrawable
        }

        val dataSets = mutableListOf<ILineDataSet>()
        dataSets.add(set)
        lineChart.apply {
            description.isEnabled = false
            axisRight.isEnabled = false
            this.data = LineData(dataSets)
            invalidate()
        }
    }

}