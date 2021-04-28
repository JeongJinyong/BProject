package dpm.project.b.b_project.ui.story

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isInvisible
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import dpm.project.b.b_project.R
import dpm.project.b.b_project.base.BaseActivity
import dpm.project.b.b_project.databinding.ActivityStoryBinding
import dpm.project.b.b_project.ui.story.StoryAdapter.Item

class StoryActivity : BaseActivity<ActivityStoryBinding, StoryViewModel>() {
  override val layoutId: Int = R.layout.activity_story
  override val viewModel: StoryViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.startClick.observe(this, {

    })
    val array = resources.getStringArray(R.array.story_text)
      .zip(listOf(R.drawable.story_first, R.drawable.story_second, R.drawable.story_third)) { text, image -> Item(text, image) }
    dataBinding.vpStory.adapter = StoryAdapter(array)
    dataBinding.vpStory.registerOnPageChangeCallback(object : OnPageChangeCallback() {
      override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        dataBinding.tvStart.isInvisible = position < 2
        dataBinding.progressStory.progress = position + 1
      }
    })
  }
}