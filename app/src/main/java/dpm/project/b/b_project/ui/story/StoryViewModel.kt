package dpm.project.b.b_project.ui.story

import android.app.Application
import dpm.project.b.b_project.base.BaseViewModel
import dpm.project.b.b_project.utils.SingleLiveEvent

class StoryViewModel(application: Application) : BaseViewModel(application) {
  private val _startClick = SingleLiveEvent<Unit>()
  val startClick: SingleLiveEvent<Unit> get() = _startClick

  fun onStartClick() {
    _startClick.call()
  }
}