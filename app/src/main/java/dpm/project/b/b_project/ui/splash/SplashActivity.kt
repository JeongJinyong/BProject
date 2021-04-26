package dpm.project.b.b_project.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.Nullable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import dpm.project.b.b_project.R
import dpm.project.b.b_project.R.drawable
import dpm.project.b.b_project.base.BaseActivity
import dpm.project.b.b_project.databinding.ActivitySplashBinding
import dpm.project.b.b_project.dummy.DummyViewModel
import dpm.project.b.b_project.ui.story.StoryActivity

class SplashActivity : BaseActivity<ActivitySplashBinding, DummyViewModel>() {
  override val layoutId: Int = R.layout.activity_splash
  override val viewModel: DummyViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Glide.with(this)
      .asGif()
      .load(drawable.blife)
      .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
      .listener(object : RequestListener<GifDrawable> {
        override fun onLoadFailed(
          @Nullable e: GlideException?,
          model: Any,
          target: Target<GifDrawable>,
          isFirstResource: Boolean
        ): Boolean {
          return false
        }

        override fun onResourceReady(
          resource: GifDrawable,
          model: Any,
          target: Target<GifDrawable>,
          dataSource: com.bumptech.glide.load.DataSource,
          isFirstResource: Boolean
        ): Boolean {
          resource.setLoopCount(1)
          Thread {
            while (true) {
              try {
                Thread.sleep(200)
              } catch (e: InterruptedException) {
                e.printStackTrace()
              }
              if (!resource.isRunning) {
                startActivity(Intent(this@SplashActivity, StoryActivity::class.java))
                finish()
              }
            }
          }.start()
          return false
        }
      }).into(dataBinding.imgSplash)
  }
}