package jo.kotlin.mvpsample.view.data

import com.google.gson.annotations.SerializedName
import jo.kotlin.mvpsample.util.Mockable

/**
 * Created by Jo on 2018. 3. 29.
 */

@Mockable
data class PhotoResponse(
        @SerializedName("photos") val photos: Photos,
        @SerializedName("stat") val stat: String,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String
)
@Mockable
data class Photos(
        @SerializedName("page") val page: Int,
        @SerializedName("pages") val pages: String,
        @SerializedName("perpage") val perpage: Int,
        @SerializedName("total") val total: String,
        @SerializedName("photo") val photo: ArrayList<Photo>
)
@Mockable
data class Photo(
        @SerializedName("id") val id: String,
        @SerializedName("owner") val owner: String,
        @SerializedName("secret") val secret: String,
        @SerializedName("server") val server: String,
        @SerializedName("farm") val farm: Int,
        @SerializedName("title") val title: String,
        @SerializedName("ispublic") val ispublic: Int,
        @SerializedName("isfriend") val isfriend: Int,
        @SerializedName("isfamily") val isfamily: Int

) {
    fun getPhotoURL(): String = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}