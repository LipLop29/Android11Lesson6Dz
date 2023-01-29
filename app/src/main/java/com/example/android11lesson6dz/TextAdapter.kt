package com.example.android11lesson6dz

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.content.Context
import android.view.ContextMenu
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.contextaware.ContextAware
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.android11lesson6dz.`interface`.OnItemTextListener
import com.example.android11lesson6dz.data.TextModel
import com.example.android1lesson6dz.databinding.ItmeTextBinding

class TextAdapter(
    private val listText: MutableList<TextModel>,
    private val onItemTextListener: OnItemTextListener
) : RecyclerView.Adapter<TextAdapter.TextViewHolder>(), View.OnLongClickListener {

    inner class TextViewHolder(var binding: ItmeTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(textModel: TextModel) {
            binding.btnItem.setOnClickListener {
                listText.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
            binding.textMain.text = textModel.text
            itemView.setOnClickListener {
                onItemTextListener.onClick(textModel)
                binding.textMain.text = textModel.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            ItmeTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listText[position])
        holder.itemView.setOnLongClickListener {
            listText.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listText.size

    override fun onLongClick(v: View?): Boolean {
        onItemTextListener.onLongClick(v?.tag as TextModel)
        return true
    }
}