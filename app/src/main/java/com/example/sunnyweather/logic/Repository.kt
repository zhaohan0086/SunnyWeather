package com.example.sunnyweather.logic
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlin.Exception
import kotlin.RuntimeException
import kotlin.Result
//不过我个人认为，这种搜索城市数据的请求并没有太多缓存的必要，每次都发起网络请求去获
//取最新的数据即可，因此这里就不进行本地缓存的实现了。在logic包下新建一个Repository
//单例类，作为仓库层的统一封装入口
object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException(
                    "response status is${placeResponse.status}" ))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}
