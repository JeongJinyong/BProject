package dpm.project.b.b_project.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dpm.project.b.b_project.BR

abstract class BaseFragment<T : ViewDataBinding, E : ViewModel> : Fragment() {
  lateinit var dataBinding: T

  abstract val layoutId: Int
  abstract val viewModel: E

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
    dataBinding.lifecycleOwner = this
    dataBinding.setVariable(BR.viewModel, viewModel)

    return dataBinding.root
  }
}