package pl.makzyt.carrental.util

object PathUtil {
    fun resourcesPath(): String {
        return System.getProperty("user.dir") + "/src/main/resources/"
    }

    fun imagesPath(): String {
        return resourcesPath() + "/static/images/"
    }

    fun uploadsPath(): String {
        return imagesPath() + "uploads/"
    }
}