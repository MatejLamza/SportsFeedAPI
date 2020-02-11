package com.example.sportapitask.internal

interface Mapper<I,O> {
    fun map(input:I):O
}