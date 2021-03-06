package soup.qr.util

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

object Gallery {

    private const val REQUEST_GET_SINGLE_FILE = 1

    fun takePicture(fragment: Fragment) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/*"
        fragment.startActivityForResult(
            Intent.createChooser(intent, "Select Picture"),
            REQUEST_GET_SINGLE_FILE
        )
    }

    fun onPictureTaken(requestCode: Int, resultCode: Int, data: Intent?, callback: (Uri) -> Unit) {
        if (requestCode == REQUEST_GET_SINGLE_FILE && resultCode == RESULT_OK) {
            data?.data?.run(callback)
        }
    }
}
