package companies.tavant


/*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.coroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import javax.inject.Singleton

// 1. Parallel API calls

class MyViewModel(
    private val repo: Repository
) : ViewModel() {

    fun fetchDashboardData() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val profile = async { repo.getProfile() }
                    val accounts = async { repo.getAccounts() }

                    val dashboard = Dashboard(
                        profile.await(),
                        accounts.await()
                    )

                    println(dashboard)
                }
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }
}

// 2. Retrofit Dependency Injection

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        interceptor: Interceptor
    ): Retrofit {

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://example.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

// 3. Jetpack Compose List

@Composable
fun UserScreen(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            UserRow(user)
        }
    }
}*/
