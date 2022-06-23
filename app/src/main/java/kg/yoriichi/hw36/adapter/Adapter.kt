package kg.yoriichi.hw36.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.yoriichi.hw36.databinding.ImageItemBinding
import kg.yoriichi.hw36.extension.load
import java.util.ArrayList

class Adapter(private val list: ArrayList<String>,
              private val onClick: (image: String) -> Unit?,
              private val onRemove: (image: String) -> Unit?,
):RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private var binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(image: String) {
            binding.ivImage.load(image)
            binding.ivImage.load(image)
            binding.ivImage.setOnClickListener {
                if (binding.background.visibility == View.GONE) {
                    binding.background.visibility = View.VISIBLE
                    onClick(image)
                } else {
                    binding.background.visibility = View.GONE
                    onRemove(image)
                }
            }
        }
    }
}