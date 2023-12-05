package dev.klepto.advent2023.util

/**
 * @author <a href="http://github.com/klepto">Augustinas R.</a>
 */
object Resources {

    fun readTextResource(resource: String): String {
        return (Resources::class.java.getResource("/$resource")
            ?: throw RuntimeException("Could not read the '$resource' resource.")).readText()
    }

}