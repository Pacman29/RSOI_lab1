package com.rsoi.lab1.Models

import java.util.*

data class ActionModel(
        val type: String,
        val param1: Double,
        val param2: Double,
        val res: Double,
        val time: Date = Date())