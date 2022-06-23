package kg.yoriichi.hw36.ui


import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import kg.yoriichi.hw36.adapter.Adapter
import kg.yoriichi.hw36.base.BaseActivity
import kg.yoriichi.hw36.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(){

    override fun inflateViewBinding(inflater: LayoutInflater): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
        val list = intent.getStringArrayListExtra(MainActivity.KEY)
        binding.recycler.adapter = list?.let { Adapter(it,this::onClick,this::onRemove) }
        binding.recycler.layoutManager = GridLayoutManager(this, 3)
    }
    private fun onClick(position: String) = Unit
    private fun onRemove(position: String) = Unit

}