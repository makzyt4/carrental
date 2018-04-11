package pl.makzyt.carrental.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.io.File
import java.nio.file.Files

@Controller
class ImagesController {
    @GetMapping("/images/uploads/car/{name}", produces = [MediaType.IMAGE_PNG_VALUE])
    fun showUploadedFile(@PathVariable("name") name: String, model: Model): ResponseEntity<ByteArray> {
        val file = File(System.getProperty("user.dir") + "/src/main/resources/static/images/uploads/car/$name")
        val bytes = Files.readAllBytes(file.toPath())
        val headers = HttpHeaders()
        return ResponseEntity(bytes, headers, HttpStatus.OK)
    }
}