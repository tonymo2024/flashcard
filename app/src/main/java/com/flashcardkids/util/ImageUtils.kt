package com.flashcardkids.util

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object ImageUtils {

    fun drawableToBitmap(drawable: Drawable): Bitmap {
        return (drawable as BitmapDrawable).bitmap
    }

    fun saveBitmapToFile(bitmap: Bitmap, file: File): Boolean {
        return try {
            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                true
            }
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun getBitmapFromUri(uri: Uri, context: android.content.Context): Bitmap? {
        return MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
    }

    fun getImageUri(bitmap: Bitmap, context: android.content.Context): Uri {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, "Title", null)
        return Uri.parse(path)
    }

    fun getDrawableFromResource(resourceId: Int, context: android.content.Context): Drawable {
        return ContextCompat.getDrawable(context, resourceId)!!
    }
}