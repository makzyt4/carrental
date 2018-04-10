package pl.makzyt.carrental

object ApiUtil {
    fun getApiKey(): String? {
        return System.getenv("GOOGLE_MAPS_API_KEY")
    }
}