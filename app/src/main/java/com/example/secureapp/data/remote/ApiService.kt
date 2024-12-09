import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: Map<String, String>): Response<LoginResponse>

    @GET("user/data")
    suspend fun getUserData(@Header("Authorization") token: String): Response<UserData>
}
