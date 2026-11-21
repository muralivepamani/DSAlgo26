package practice



sealed interface UiState {
    data object Loading : UiState
    data class Success(val data: List<String>) : UiState
    data class Error(val message: String) : UiState

}

fun handleState(state: UiState) {
    when (state) {
        is UiState.Loading -> {
            //Loading
        }

        is UiState.Success -> {
            print(state.data)

        }

        is UiState.Error -> {
            print(state.message)
        }
    }
}


object Logger
class User private constructor() {
    companion object {
        fun create(): User = User()
    }
}



