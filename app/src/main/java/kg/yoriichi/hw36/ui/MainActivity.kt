package kg.yoriichi.hw36.ui


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kg.yoriichi.hw36.adapter.Adapter
import kg.yoriichi.hw36.base.BaseActivity
import kg.yoriichi.hw36.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    private lateinit var adapter: Adapter
    private val list = arrayListOf<String>()
    private val imageList = arrayListOf("https://files.masterkrasok.ru/v4/pictures/jkdv6O6Qxbw96MBxSCUl3wll7vaSUYdZNx0vyj4x.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSj1KgsOUjCVBT5-GincbSW2R4FbhhMtrarDQ&usqp=CAU",
        "https://lh3.googleusercontent.com/R54IzIh9wjxWXXS8Du68CAPuIGZqw2dPGpKcY_E8Jmi2eeN-T3XNABLDSlvL74hqfNLj_9_oz4B2qsEoTznxMqOJtFUa4jW00DR3Gc3_Jc4Tflzv_0ZPV9-T8qnyPvactywquNKW",
        "https://cdn-s-static.arzamas.academy/storage/picture/5933/gallery_picture-2fb5bb29-f538-498c-a1c3-71c0aa2d1bb3.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFSfk0Bf-6sKPmbDqZbB3m9gbiFKsubEGz5g&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVkJ6qHPO4wIozWXsgLymZcP81LH7nLC_BuA&usqp=CAU",
        "https://img.freepik.com/free-vector/spring-landscape-scene_52683-56331.jpg?size=626&ext=jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTbMEVy5XF4foYsShP6PmUSO_z9nNh_7IsNw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdKxGSSTPSpB-2F4IeqaaVxArsdbjCUbLayg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGrx51kUcKb_N5BYWf-XZzj3boUh801eHsjQ&usqp=CAU")

    override fun initView() {
        super.initView()
        adapter = Adapter(imageList, this::onClick, this::onRemove)
        binding.recycler.layoutManager = GridLayoutManager(this, 3)
        binding.recycler.adapter = adapter
    }

    private fun onClick(position: String) {
        binding.finishBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(KEY, list)
            startActivity(intent)
        }
        list.add(position)
    }

    private fun onRemove(position: String) {
        binding.cardView.visibility = View.GONE
        list.remove(position)
    }

    companion object {
        const val KEY = "key"
    }
}


