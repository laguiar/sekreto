package io.github.sekreto

import java.nio.file.Files
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

private const val FILE_INPUT = "english.txt"

@Path("/sekreto")
class App {

    private val table = generateCodeTable(
        Files.readAllLines(
            java.nio.file.Path.of(this::class.java.classLoader.getResource(FILE_INPUT).toURI())
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    fun generate(): Response {
        val response = Response.ok()
            .header("Content-Disposition", "attachment;filename=$FILE_OUTPUT")

        val file = prepareOutput(table)
        file.deleteOnExit()

        return response
            .entity(file)
            .build()
    }

}
