package kg.yoriichi.hw36.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)

        checkInternet()
        initViewModel()
        initView()
        initListener()
    }

    open fun initView() {}
    open fun initListener()  {}
    open fun initViewModel()  {}
    open fun checkInternet() {}
}