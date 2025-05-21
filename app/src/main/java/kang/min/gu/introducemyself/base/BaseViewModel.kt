package kang.min.gu.introducemyself.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BaseViewModel<State : Reducer.ViewState, Event : Reducer.ViewEvent, Effect : Reducer.ViewEffect>(
    initialState: State,
    private val reducer: Reducer<State, Event, Effect>
) : ViewModel() {

    private val _event = Channel<Event>(capacity = Channel.CONFLATED)

    val state = _event.receiveAsFlow()
        .runningFold(initialState, ::reduceState)
        .stateIn(viewModelScope, SharingStarted.Eagerly, initialState)

    private val _effect = Channel<Effect>(capacity = Channel.CONFLATED)
    val effect = _effect.receiveAsFlow()

    private fun reduceState(state: State, event: Event): State {
        val (newState, effect) = reducer.reduce(state, event)

        effect?.let {
            viewModelScope.launch {
                _effect.send(it)
            }
        }

        return newState
    }

    fun sendEvent(event: Event) {
        viewModelScope.launch {
            _event.send(event)
        }
    }

    override fun onCleared() {
        super.onCleared()
        _event.cancel()
        _effect.cancel()
    }
}