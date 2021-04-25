package dpm.project.b.b_project.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.File

fun ImageView.imageLoad(
  url: String,
  requestOptions: RequestOptions = defaultImageRequestOptions()
) {
  Glide.with(context).load(url).apply(requestOptions).into(this)
}

fun ImageView.imageLoad(file: File, requestOptions: RequestOptions = defaultImageRequestOptions()) {
  Glide.with(context).load(file).apply(requestOptions).into(this)
}

fun ImageView.imageLoad(
  @DrawableRes resId: Int,
  requestOptions: RequestOptions = defaultImageRequestOptions()
) {
  Glide.with(context).load(resId).apply(requestOptions).into(this)
}

fun ImageView.imageLoad(
  drawable: Drawable,
  requestOptions: RequestOptions = defaultImageRequestOptions()
) {
  Glide.with(context).load(drawable).apply(requestOptions).into(this)
}