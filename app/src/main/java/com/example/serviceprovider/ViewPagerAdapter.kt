package com.example.serviceprovider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.serviceprovider.databinding.ItemPageBinding


class ViewPagerAdapter(
    private var titleFirstLine:List<String>,
    private var titleSecondLine:List<String>,
    private  var desc: String) :RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val binding = ItemPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val firstLine = titleFirstLine[position]
        val secondLine = titleSecondLine[position]
        val desc = desc
        holder.bind(firstLine, secondLine, desc)

    }

    override fun getItemCount(): Int {
        return titleFirstLine.size
    }

    class ViewPagerHolder(private var itemPageBinding: ItemPageBinding) :
        RecyclerView.ViewHolder(itemPageBinding.root) {
        fun bind(firstLine: String, secondLine: String, desc: String) {

            itemPageBinding.tvSplashTitleFirstLine.text = firstLine
            itemPageBinding.tvSplashTitleSecondLine.text = secondLine
            itemPageBinding.tvSplashDesc.text = desc
            itemPageBinding.ivImage.setImageResource(R.mipmap.ic_launcher_round)

            itemPageBinding.ivImage.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You clicked on item #${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
