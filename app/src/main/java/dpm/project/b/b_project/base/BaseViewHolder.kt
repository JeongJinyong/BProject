package dpm.project.b.b_project.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
  abstract fun onBindViewHolder(data: Any?)
}