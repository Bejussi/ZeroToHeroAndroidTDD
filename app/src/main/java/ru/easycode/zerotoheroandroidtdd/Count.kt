package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): UiState

    class Base(
        private val step: Int,
        private val max: Int
    ): Count {

        init {
            when {
                step < 1 -> throw IllegalStateException("step should be positive, but was $step")
                max < 1 -> throw IllegalStateException("max should be positive, but was $max")
                max < step -> throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val result = digits + step
            return if (result + step <= max) {
                UiState.Base(text = result.toString())
            } else {
                UiState.Max(text = result.toString())
            }
        }
    }
}