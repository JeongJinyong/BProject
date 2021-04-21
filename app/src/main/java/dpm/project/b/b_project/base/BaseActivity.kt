package dpm.project.b.b_project.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dpm.project.b.b_project.BR

abstract class BaseActivity<T : ViewDataBinding, E : ViewModel> : AppCompatActivity() {
  lateinit var dataBinding: T

  abstract val layoutId: Int
  abstract val viewModel: E

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    initDataBinding()
  }

  private fun initDataBinding() {
    dataBinding = DataBindingUtil.setContentView(this, layoutId)
    dataBinding.lifecycleOwner = this
    dataBinding.setVariable(BR.viewModel, viewModel)
  }
}
