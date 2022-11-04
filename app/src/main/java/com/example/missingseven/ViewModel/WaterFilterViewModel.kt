package com.example.missingseven.ViewModel

import androidx.lifecycle.ViewModel
import com.example.missingseven.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WaterFilterViewModel @Inject constructor(
) : ViewModel() {

    var data = mutableListOf<WaterFilterBean>()

    fun initData() {
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
        data.add(WaterFilterBean())
    }

    fun click(index: Int) {
        data[index].img = R.mipmap.ic_water_filter
    }
}

data class WaterFilterBean(var img: Int = 0)