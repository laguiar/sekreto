package io.github.sekreto

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

private const val FILE_INPUT = "/english.txt"

@Path("/sekreto")
class App {

    private val words = this::class.java.getResourceAsStream(FILE_INPUT)
        .bufferedReader()
        .readLines()

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    fun generate(): Response {
        val table = generateCodeTable(words)
        val file = prepareOutput(table)
        file.deleteOnExit()

        return Response.ok()
            .header("Content-Disposition", "attachment;filename=$FILE_OUTPUT")
            .entity(file)
            .build()
    }

}
