package dpm.project.b.b_project.base

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

  protected val _error = MutableLiveData<Exception>()
  val error: LiveData<Exception> get() = _error

  protected fun <T> runScope(
    req: suspend CoroutineScope.() -> T,
    res: ((T) -> Unit)? = null
  ) {
    viewModelScope.launch(Dispatchers.IO) {
      try {
        req().also { value ->
          launch(Dispatchers.Main) {
            value.toString().apply {
              if (contains("result=")) {
                val index = indexOf("result=") + "result=".length
                val result = substring(index, index + 4)
                if (result != "1001") {
                  _error.postValue(IllegalStateException(value.toString()))
                  return@launch
                }
              }
            }
            res?.invoke(value)
          }
        }
      } catch (e: java.lang.Exception) {
        e.printStackTrace()
        _error.postValue(e)
      }
    }
  }
}