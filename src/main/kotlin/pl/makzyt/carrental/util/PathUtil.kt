package pl.makzyt.carrental.util

import java.io.File

object PathUtil {
    fun resourcesPath(): String {
        return System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "resources" +
                File.separator
    }

    fun imagesPath(): String {
        return resourcesPath() + "uploads" + File.separator
    }
}