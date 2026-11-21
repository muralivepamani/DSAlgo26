package companies.coforge

/*
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*

class PreferencesUtils(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    fun getString(key: String, defaultValue: String = ""): String =
        preferences.getString(key, defaultValue) ?: defaultValue

    fun saveString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }
}

class MyViewModel : ViewModel() {

    private val flow1 = flowOf(1, 2, 3)
    private val flow2 = flowOf(4, 5, 6)

    val outputFlow: SharedFlow<Int> = merge(flow1, flow2)
        .shareIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            replay = 0
        )
}*/
