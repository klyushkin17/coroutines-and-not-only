package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.awt.Button

//StateFlow - это горячий стрим данных, который хранит в себе одно значение и оповещает collector, когда оно изменяется

fun main() {

    val viewModel = ViewModel()
    viewModel.incrementCounter()
    println(viewModel.stateFlow.value)

    // Если работать через Compose:
    /*val viewModel = viewModel<ViewModel>()
    val count = viewModel.stateFlow.collectAsState(initial = 10)

    Button(
        onClick = {viewModel.incrementCounter()}
    ){
        Text(
            text = count
        ){
        }
    }*/


    // Если собирать данные из state из XML:
    /*lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewMo del.stateFlow.collectLatest { number ->
                binding.tvCounter.text = number.toString()
            }
        }
    }*/
}

class ViewModel() {
    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<Int>(replay = 10) // Аргумент replay позволяет кэшировать данные в sharedFlow
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        squareNumber(5)

        CoroutineScope(Dispatchers.Main).launch {
            sharedFlow.collect { result ->
                println(result)
                delay(1000L)
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            sharedFlow.collect { result ->
                println(result)
                delay(2000L)
            }
        }
    }

    fun incrementCounter() {
        _stateFlow.value += 1
    }

    fun squareNumber(number: Int) {
        CoroutineScope(context = Dispatchers.Main).launch {
            _stateFlow.emit(number * number)
        }
    }
}

