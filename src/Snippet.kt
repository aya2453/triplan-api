package `fun`.triplan

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Snippet(val text: String)