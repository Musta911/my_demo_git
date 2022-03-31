import java.io.Serializable
import kotlin.random.Random

class Category (val title : String, val description : String, val imageUrl : String? = null, val tags : MutableList<String>, val id : String) {

    private fun addTag(text : String) {
        tags.add(text)
    }
    private fun removeTag(text: String) {
        tags.remove(text)
    }
}