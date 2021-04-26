package dpm.project.b.b_project.ui.story

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import dpm.project.b.b_project.base.BaseViewHolder
import dpm.project.b.b_project.databinding.ItemStoryBinding
import dpm.project.b.b_project.utils.imageLoad

class StoryAdapter(private val items: List<Item>) : RecyclerView.Adapter<BaseViewHolder>() {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): BaseViewHolder {
    val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(
    holder: BaseViewHolder,
    position: Int
  ) = holder.onBindViewHolder(items[position])

  override fun getItemCount() = items.size

  data class Item(
    val text: String,
    @DrawableRes val image: Int
  )

  class ViewHolder(private val viewBinding: ItemStoryBinding) : BaseViewHolder(viewBinding.root) {
    override fun onBindViewHolder(data: Any?) {
      if (data !is Item) return
      viewBinding.imgStory.imageLoad(data.image)
      viewBinding.txtStory.text =
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) Html.fromHtml(data.text, HtmlCompat.FROM_HTML_MODE_LEGACY)
        else Html.fromHtml(data.text)
    }
  }
}